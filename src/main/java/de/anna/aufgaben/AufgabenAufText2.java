package de.anna.aufgaben;

public class AufgabenAufText2 {


    public static void main(String[] args) {

        //String str1 = entferneTextImKlammern("aa(bb)cc(dd)ee(ff)gg");
        String str2 = entferneTextImKlammern("aa((bb))cc((dd))ee((ff))gg");
        System.out.println(str2);
    }

    public static String entferneTextImKlammern(String text) {

      StringBuffer stringBuffer = new StringBuffer();

        int indexOfStartKlammer = 0;

        indexOfStartKlammer = text.indexOf("((");
        String substringVorErstenKlammern = text.substring(0, indexOfStartKlammer);
        stringBuffer.append(substringVorErstenKlammern);

        while(true){

            int indexOfEndKlammer = text.indexOf("))", indexOfStartKlammer);
            indexOfStartKlammer = text.indexOf("((", indexOfStartKlammer + 2);

            if (indexOfStartKlammer == -1 || indexOfEndKlammer == -1) {
                String substringBisEndeString = text.substring(indexOfEndKlammer + 2);
                stringBuffer.append(substringBisEndeString);
                break;
            }

            String substringZwischenKlammern = text.substring(indexOfEndKlammer + 2, indexOfStartKlammer);
            stringBuffer.append(substringZwischenKlammern);
        }

      return stringBuffer.toString();
    }
}