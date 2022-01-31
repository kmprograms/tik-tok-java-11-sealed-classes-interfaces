public class App1 {
    /*
        Dzięki oznaczeniu klasy A jako sealed możesz
        jawnie i precyzyjnie określić, które klasy
        mogą rozszerzać tę klasę. Po słowie kluczowym
        permits podajemy klasy A1 oraz A2, które mogą
        rozszerzać klasę A.
        To pozwala na lepszą organizację kodu i jest
        pewną formą jego dokumentowania (możesz szybko
        ustalić która klasa, po której dziedziczy).
    */
    static sealed class A permits A1, A2 {
        public void m() {
            System.out.println("A");
        }
    }

    /*
        Klasa, którą umieszczono po słowie kluczowym
        permits, musi być sealed, non-sealed lub permits.
        Wszystkie klasy muszą znajdować się w tej samej
        paczce.
    */
    static non-sealed class A1 extends A {
        @Override
        public void m() {
            System.out.println("A1");
        }
    }

    static final class A2 extends A {
        @Override
        public void m() {
            System.out.println("A2");
        }
    }

    // Podobnie możesz stosować słowo kluczowe sealed
    // w przypadku interfejsów
    static sealed interface B permits B1 {
        void m();
    }

    static non-sealed class B1  implements B {
        @Override
        public void m() {
            System.out.println("B1");
        }
    }

    public static void main(String[] args) {
        var a = new A();
        a.m();

        var a1 = new A1();
        a1.m();

        var a2 = new A2();
        a2.m();

        var b = new B1();
        b.m();
    }
}
