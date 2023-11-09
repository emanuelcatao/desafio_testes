import org.example.Calculadora;
import org.junit.*;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThrows;

public class CalculadoraTest {
    private Calculadora calculadora;

    @Before
    public void setUp() {
        this.calculadora = new Calculadora("HP");
    }

    @Test
    public void testCriacaoCalculadora(){
        Assert.assertNotNull("Calculadora nao inicializada", calculadora);
    }

    @Test
    public void testAdd() {
        double soma = calculadora.add(2.2, 1.1);
        Assert.assertEquals("Erro ao somar.",3.3, soma, 0.1);
    }

    @Test
    public void testSub() {
        Assert.assertTrue("Erro ao subtrair.", calculadora.sub(2.2, 1.1) == 1.1);
    }

    @Test
    public void testMult() {
        Assert.assertThat(calculadora.mult(2, 2), CoreMatchers.is(equalTo(4.0)));
    }

    @Test
    public void testDiv() {
        Assert.assertEquals("Erro ao somar.",2, calculadora.div(4,2), 0.00001);
    }

    @Test
    public void testDivPorZero() {
        Throwable throwable = assertThrows(
                ArithmeticException.class,
                () -> calculadora.div(1, 0)
        );

        Assert.assertEquals("Divisão por zero", throwable.getMessage());
    }


    @Test
    public void testArrayResposta() {
        Assert.assertArrayEquals(new double[]{2.0, 1.0, 3.0}, new double[]{calculadora.add(1.0, 1.0), calculadora.sub(3.0, 2.0), calculadora.mult(1.0, 3.0)}, 0.1);
    }

    @Test
    public void testCompararMarcasCalculadoras() {
        Calculadora calculadora1 = new Calculadora("Kenko");
        Assert.assertNotEquals("Calculadoras de marcas diferentes",calculadora, calculadora1);
    }

    @Test
    public void testCompararCalculadoras() {
        Calculadora calculadora1 = new Calculadora("HP");
        Assert.assertNotSame("Não são a mesma calculadora!", calculadora, calculadora1);
    }

    @AfterClass
    public static void after() {
        System.out.println("Testes foram executados");
    }
}
