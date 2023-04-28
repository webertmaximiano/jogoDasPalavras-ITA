package EmbaralharPalavras;

import java.util.ArrayList;
import java.util.List;

public class EmbaralharPrimeiroParDepoisImpar implements Embaralhador{
    @Override
    public String embaralhar(String palavra) {
        char[] caracteres = palavra.toCharArray();
        List<Character> impares = new ArrayList<>();
        List<Character> pares = new ArrayList<>();
        for (int i = 0; i < caracteres.length; i++) {
            if (i % 2 == 0) {
                pares.add(caracteres[i]);
            } else {
                impares.add(caracteres[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : pares) {
            sb.append(c);
        }
        for (char c : impares) {
            sb.append(c);
        }
        return sb.toString();
    }
}
