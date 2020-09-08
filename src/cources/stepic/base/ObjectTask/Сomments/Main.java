package cources.stepic.base.ObjectTask.Сomments;


public class Main {

    public static void main(String[] args) {

        String[] spam = {"купи", "dsfsd", "dsfsdf"};

        KeywordAnalyzer spamAnalyzer1 = new Main().new SpamAnalyzer(spam);
        KeywordAnalyzer negativeTextAnalyzer2 = new Main().new NegativeTextAnalyzer();
        TextAnalyzer tooLongTextAnalyzer3 = new Main().new TooLongTextAnalyzer(10);

        TextAnalyzer[] textAnalyzer = new TextAnalyzer[]{spamAnalyzer1, negativeTextAnalyzer2, tooLongTextAnalyzer3};

        System.out.println(new Main().checkLabels(textAnalyzer, "купи эту ненужную тебе хрень"));
    }

//=======================================================================================================================

    public Label checkLabels(TextAnalyzer[] analyzers, String text) {

        for (TextAnalyzer textanalyzer : analyzers) {
              textanalyzer.processText(text);
            if (textanalyzer.processText(text).equals(Label.SPAM)) return Label.SPAM;
            if (textanalyzer.processText(text).equals(Label.NEGATIVE_TEXT)) return Label.NEGATIVE_TEXT;
            if (textanalyzer.processText(text).equals(Label.TOO_LONG)) return Label.TOO_LONG;

        }
        return Label.OK;
    }

//=======================================================================================================================

    interface TextAnalyzer {
        Label processText(String text);
    }

    enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    }

//=======================================================================================================================

    abstract class KeywordAnalyzer implements TextAnalyzer {

        @Override
        public Label processText(String text) {

            //String a;
            for (int i = 0; i < getKeywords().length; i++) {
                //a = getKeywords()[i];
                if(text.contains(getKeywords()[i])){
                    return getLabel();
                }
            }

            return Label.OK;

        }
        protected abstract String [] getKeywords();
        protected abstract Label getLabel();
    }

//=======================================================================================================================


    class SpamAnalyzer extends KeywordAnalyzer {
        private String[] keywords;

        public SpamAnalyzer(String[] keywords) {
            this.keywords = keywords;
        }

        @Override
        protected String [] getKeywords() {
            return keywords;
        }

        @Override
        protected Label getLabel() {
            return Label.SPAM;
        }

    }

//=======================================================================================================================

    class NegativeTextAnalyzer extends KeywordAnalyzer {
        public NegativeTextAnalyzer() {
        }

        String [] str = { ":(" , "=(" , ":|" };

        @Override
        protected String [] getKeywords() {

            return str;
        }

        @Override
        protected Label getLabel() {
            return Label.NEGATIVE_TEXT;
        }

    }

//=======================================================================================================================

    class TooLongTextAnalyzer implements TextAnalyzer {

        private int maxLength;

        public TooLongTextAnalyzer(int maxLength) {
            this.maxLength = maxLength;
        }

        @Override
        public Label processText(String text) {
            if (maxLength >= text.length()) return Label.OK;
            return Label.TOO_LONG;
        }
    }

}




