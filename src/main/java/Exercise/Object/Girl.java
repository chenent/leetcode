package Exercise.Object;


/**
 * java多态，父类引用指向子类对象
 *         Girl girl=new MMGirl();
 */
public class Girl {

    public void smile(){
        System.out.println("Girl simle");
    }

    static class MMGirl extends Girl{

        @Override
        public void smile(){
            System.out.println("MMGirl smile");
        }
    }

    public static void main(String[] args) {
        Girl girl=new MMGirl();
        girl.smile();

        MMGirl mmGirl=new MMGirl();
        if(mmGirl instanceof Girl){
            System.out.println("mmGirl instanceof Girl Yes");
        }
        else
        {
            System.out.println("mmGirl instanceof Girl No");

        }

        Girl girl1=new Girl();
        if(girl1 instanceof MMGirl){
            System.out.println("girl1 instanceof MMGirl Yes");
        }
        else
        {
            System.out.println("girl1 instanceof MMGirl No");

        }
    }
}


