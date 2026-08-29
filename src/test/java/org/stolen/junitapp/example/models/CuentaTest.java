package org.stolen.junitapp.example.models;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.stolen.junitapp.example.exceptions.DineroInsuficienteException;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

class CuentaTest {

    private Cliente cliente;
    private Cuenta cuenta;
    private TestInfo testInfo;
    private TestReporter testReporter;

    @BeforeEach
    void startUp() {
        System.out.println("Empezando el test cuenta principal");
        cliente = new Cliente(1);
        cuenta = new Cuenta("CTA-005", 100.00, cliente);
    }

    @BeforeEach
    void initMethodTest(TestInfo testInfo, TestReporter testReporter) {
        cliente = new Cliente(1);
        this.cuenta = new Cuenta("CTA-005", 100.00, cliente);
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        System.out.println("Ejecutando TestMethod: " + Objects.requireNonNull(testInfo.getTestMethod().orElse(null)).getName());
        System.out.println("Ejecutando testClass: " + testInfo.getTestClass());
        System.out.println("Ejecutando DisplayName: " + testInfo.getDisplayName());
        System.out.println("Ejecutando Tags: " + testInfo.getTags());
    }

    @Nested
    @DisplayName("Probando atributos de la cuenta")
    class CuentaTestComparando {

        @BeforeEach
        void starCuenta() {
            System.out.println("Empezando test de atributos de la cuenta");
        }

        @Test
        @DisplayName("Probando el saldo de la cuenta")
        void testSaldoCuenta() {
            assertEquals(100, cuenta.getSaldo());
            assertFalse(cuenta.getSaldo() < 0);
            assertNotNull(cuenta.getNumero());
        }

        @Test
        @DisplayName("Probando el nombre de la cuenta corriente")
        void testNombreCuenta() {

            assertTrue(cuenta.getNumero().startsWith("CTA"));
        }

        @Test
        @DisplayName("Comparando dos objetos")
        void testCompararObjeto() {
            Cliente cliente = new Cliente(2, "Pedro", "Garcia", 300);
            Cuenta cuenta = new Cuenta(1, "CTA-006", 100.00, cliente);
            Cuenta cuenta2 = new Cuenta(1, "CTA-006", 100.00, cliente);
            assertEquals(cuenta, cuenta2);
        }

        @Test
        @DisplayName("Saldo insuficiente")
        void testDineroInsuficienteExceptionCuenta() {
            Cliente cliente = new Cliente(2);
            cuenta = new Cuenta(1, "CTA-006", 1000.00, cliente);
            Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
                cuenta.debito(2000.00);
            });
            String actual = exception.getMessage();
            String esperado = "Dinero insuficiente";
            assertEquals(esperado, actual);
        }

        @AfterEach
        void endCuenta() {
            System.out.println("Terminando el test de la cuenta");
        }

    }

    @Nested
    class debitoTest {
        @Test
        @DisplayName("Debito")
        void testDebitoCuenta() {
            Cliente cliente = new Cliente(2);
            cuenta = new Cuenta("CTA-005", 1000.00, cliente);
            cuenta.debito(100.00);
            assertNotNull(cuenta.getSaldo());
            assertEquals(900, cuenta.getSaldo());
        }

    }


    @Nested
    class creditoTest {
        @Test
        @DisplayName("Credito")
        void testCreditoCuenta() {
            Cliente cliente = new Cliente(2);
            cuenta = new Cuenta(1, "CTA-006", 1000.00, cliente);
            cuenta.credito(20.00);
            assertNotNull(cuenta.getSaldo());
            assertEquals(1020.00, cuenta.getSaldo());

        }
    }


    @Test
    @DisplayName("Transferir dinero a otra cuenta")
    void testTransferirDineroCuentas() {
        Cliente cliente = new Cliente(2, "Jacqueline", "Flores", 300);
        Cliente cliente2 = new Cliente(2, "Stolen", "flowerss", 300);
        Cuenta c1 = new Cuenta(1, "CTA-005", 100.00, cliente);
        Cuenta c2 = new Cuenta(2, "CTA-006", 200.00, cliente2);

        Banco banco = new Banco();
        banco.addCuenta(c1);
        banco.addCuenta(c2);
        banco.setNombre("Banco del estado");
        banco.transferir(c2, c1, 100.00);

        assertAll(
                () -> assertEquals(100, c2.getSaldo(), "Error, no es el resultado esperado."),
                () -> assertEquals(200, c1.getSaldo()),
                () -> assertEquals(2, banco.getCuentas().size(), "Error en las cantidades de cuentas."),
                () -> assertEquals("Banco del estado", c1.getBanco().getNombre()),
                () -> assertEquals("Jacqueline", banco.getCuentas()
                        .stream()
                        .filter(c -> c.getCliente().getNombre().equals("Jacqueline"))
                        .findFirst()
                        .get()
                        .getCliente()
                        .getNombre(), "Error, los campos no coinciden"),
                () -> assertTrue(banco.getCuentas().stream().anyMatch(c -> c.getCliente().getNombre().equals("Stolen")))
        );

    }

    @AfterAll
    static void endUp() {
        System.out.println("Terminado el test");
    }

    @Nested
    class SistemaOperativoTest {
        @Test
        @DisplayName("Solo Windows")
        @EnabledOnOs(OS.WINDOWS)
        void testSoloWindows() {
            System.out.println("Solo sistema operativo windows");
        }

        @Test
        @DisplayName("Solo Windws y Mac")
        @EnabledOnOs({OS.WINDOWS, OS.MAC})
        void soloJdk11() {
        }

    }

    @Nested
    class JavaVersionTest {

        @Test
        @DisplayName("Solo JAVA17")
        @EnabledOnJre(JRE.JAVA_17)
        void testSoloJre17() {
        }

        @Test
        @DisplayName("Solo JAVA 17 Y 21")
        @EnabledOnJre({JRE.JAVA_17, JRE.JAVA_21})
        void testSoloJre17and21() {
        }

    }


    @Test
    @DisplayName("Probando Dev")
    void testSaldoCuentaDev() {
        boolean esDev = "dev".equals(System.getProperty("ENV"));
        assumeTrue(esDev);
        assertEquals(100, cuenta.getSaldo());
        assertFalse(cuenta.getSaldo() < 0);
        assertNotNull(cuenta.getNumero());
    }

    @DisplayName("Repetir Debito")
    @RepeatedTest(
            value = 3,
            name = "Repeticion debito {currentRepetition} de {totalRepetitions}"
    )
    void testDebitoCuenta() {
        Cliente cliente = new Cliente(2);
        cuenta = new Cuenta("CTA-005", 1000.00, cliente);
        cuenta.debito(100.00);
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo());
    }

    @Nested
    @DisplayName("Test con Parametros")
    class parametrizarWithParameter {

        @Tag("Parametro_manualmente")
        @ParameterizedTest(name = "manualmente pruebas {index}  - {arguments}")
        @CsvSource({
                "CTA-005, 300.00, 1, 200.00",
                "CTA-006, 200.00, 1, 100.00"
        })
        void testDebitoCuentaPR(String numero, double saldoInicial, Integer idCliente, double saldoEsperado) {
            Cliente cliente = new Cliente(idCliente);
            cuenta = new Cuenta(numero, saldoInicial, cliente);
            cuenta.debito(100.00);
            assertNotNull(cuenta.getSaldo());
            assertEquals(saldoEsperado, cuenta.getSaldo());
        }

        @ParameterizedTest(name = "prueba parametros con file {index}")
        @CsvFileSource(resources = "/data.csv")
        void testDebitoCuentaFilePR(String numero, double saldoInicial, Integer idCliente, double saldoEsperado) {
            Cliente cliente = new Cliente(idCliente);
            cuenta = new Cuenta(numero, saldoInicial, cliente);
            cuenta.debito(100.00);
            assertNotNull(cuenta.getSaldo());
            assertEquals(saldoEsperado, cuenta.getSaldo());
        }
    }

    @Nested
    @Tag("Timeout")
    class timeOutEjemplo{
        @Test
        @Timeout(2)
        void testTimeoout() throws InterruptedException {
            TimeUnit.SECONDS.sleep(1);
        }

        @Test
        @Timeout(value = 2000, unit = TimeUnit.MILLISECONDS)
        void testTimeoout2() throws InterruptedException {
            TimeUnit.MILLISECONDS.sleep(1);
        }
    }
}