package ed1priscilla.br.com.caelum.ed.pilhas.testes.cripto;

import ed1priscilla.br.com.caelum.ed.pilhas.cripto.WrapperChar;

public class TesteWrapperChar {

    public static void main(String[] args) {

        /**/
        Character character = WrapperChar.toCharacter('c');
        System.out.println(character.getClass() == Character.class);
    }
}

