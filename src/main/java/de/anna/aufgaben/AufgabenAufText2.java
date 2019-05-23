package de.anna.aufgaben;

public class AufgabenAufText2 {


    public static void main(String[] args) {

        String str = entferneTextImKlammern("aa(bb)cc(dd)ee(ff)gg");
        System.out.println(str);
    }

    public static String entferneTextImKlammern(String text) {

        StringBuffer stringBuffer = new StringBuffer();

        int indexOfEndKlammer = 0;

        int indexOfStartKlammer = text.indexOf("(");
        String substringBisStartKlammer = text.substring(0, indexOfStartKlammer);
        stringBuffer.append(substringBisStartKlammer);

        while (true){

            indexOfEndKlammer = text.indexOf(")", indexOfStartKlammer);
            indexOfStartKlammer = text.indexOf("(", indexOfStartKlammer + 1);

            if(indexOfStartKlammer == -1 || indexOfEndKlammer == -1) {
                String substringBisEndeString = text.substring(indexOfEndKlammer + 1);
                stringBuffer.append(substringBisEndeString);
                break;
            }

            String substringZwischenKlammern = text.substring(indexOfEndKlammer + 1, indexOfStartKlammer);
            stringBuffer.append(substringZwischenKlammern);
        }
        return stringBuffer.toString();
    }
}
