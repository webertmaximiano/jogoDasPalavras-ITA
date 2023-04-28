package EmbaralharPalavras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmbaralharAleatório implements Embaralhador{
    @Override
    public String embaralhar(String palavra) {
        List<Character> caracteres = new ArrayList<>();
        for (char c : palavra.toCharArray()) {
            caracteres.add(c);
        }
        Collections.shuffle(caracteres);
        StringBuilder sb = new StringBuilder();
        for (char c : caracteres) {
            sb.append(c);
        }
        return sb.toString();
    }
}
