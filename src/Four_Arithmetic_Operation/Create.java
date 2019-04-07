package Four_Arithmetic_Operation;

import java.util.Random;

public class Create {
	private String[] symbol = {"+", "-", "*", "¡Â", "/"};
	Random random = new Random();

	public String create() {
        
        String str = "";
        int temp = random.nextInt(3);
        for (int j = 0; j < 3; j++) {
            if (temp == 0 && j == 0) {
                str += "(";
            } else if (temp == 2 && j == 1) {
                str += "(";
            }
            str += random.nextInt(100) % 100 + 1;
            if (temp == 0 && j == 1) {
                str += ")";
            }
            if (temp == 2 && j == 2) {
                str += ")";
            }
            String symbolElement = symbol[random.nextInt(5)];
            str += symbolElement;
            if (symbolElement == "/") {
                str += random.nextInt(100) % 100 + 1;
                symbolElement = symbol[random.nextInt(5)];
                while (true) {
                    if (symbolElement != "/") {
                        str += symbolElement;
                        break;
                    }
                    symbolElement = symbol[random.nextInt(5)];
                }
            }

        }
        str = str.substring(0, str.length() - 1);
        //System.out.println(str);
        return str;
    }
}
