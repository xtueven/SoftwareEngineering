package Four_Arithmetic_Operation;

public class Fraction {
    int fenzi;
    int fenmu;
    private Fraction temp;

    public Fraction(int a, int b) {
        /**
         * ���ݷ��ӣ���ĸ��������
         * @Param [a, b]
         * @return
         */
        fenzi = a;
        fenmu = b;
    }

    Fraction plus(Fraction r) {
        /**
         * �����ӷ�
         * @Param [r]
         * @return Fraction
         */
        temp = new Fraction(0, 0);
        temp.fenzi = fenzi * r.fenmu + fenmu * r.fenzi;
        temp.fenmu = fenmu * r.fenmu;
        return temp;
    }

    Fraction minus(Fraction r) {
        /**
         * ��������
         * @Param [r]
         * @return Fraction
         */
        temp = new Fraction(0, 0);
        temp.fenzi = fenzi * r.fenmu - fenmu * r.fenzi;
        temp.fenmu = fenmu * r.fenmu;
        return temp;
    }

    Fraction multiply(Fraction r) {
        /**
         * �����˷�
         * @Param [r]
         * @return Fraction
         */
        temp = new Fraction(0, 0);
        temp.fenzi = fenzi * r.fenzi;
        temp.fenmu = fenmu * r.fenmu;
        return temp;
    }

    Fraction divide(Fraction r) {
        /**
         * ��������
         * @Param [r]
         * @return Fraction
         */
        temp = new Fraction(0, 0);
        temp.fenzi = fenzi * r.fenmu;
        temp.fenmu = fenmu * r.fenzi;
        return temp;
    }

    String print() {
        /**
         * ����������
         * @Param []
         * @return void
         */
        if (fenzi == 0) {
            return "0";
        } else {
            int n;
            if (fenzi > fenmu)
                n = fenzi;
            else
                n = fenmu;
            int maxn = 0;
            for (int i = 1; i <= n; ++i) {//Լ��
                if (fenzi % i == 0 && fenmu % i == 0)
                    maxn = i;
            }
            int a = fenzi / maxn;
            int b = fenmu / maxn;
            if (a == b)
                return "1";
//            else if (a > b) {
//                //System.out.println(a + "/" + b);
//                return a / b + "��" + a % b + "/" + b;
//            }
            else if(b==1)
                return a+"";
            else
                return a + "/" + b;
        }
    }//print()����
}