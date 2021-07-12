public class Task1 {

        private static final String BASIC_CHARACTERS_MASK = "^[A-Za-z0-9\\h.\\h,]*$";
        private static final Pattern BASIC_CHARACTERS_PATTERN = Pattern.compile(BASIC_CHARACTERS_MASK);
        private static final double SMS_TYPE_1_PRICE_USD = 0.01;
        private static final double SMS_TYPE_2_PRICE_USD = 0.015;

        enum MessageSize {
            OPERATOR_1_MESSAGE_SIZE(160),
            OPERATOR_2_MESSAGE_SIZE_GSM_7_FORMAT(160),
            OPERATOR_2_MESSAGE_SIZE_ucs_2_FORMAT(70);

            public final int size;

            MessageSize(int size) {
                this.size = size;
            }
        }

        /*
         * Complete the 'calculateTotalMessageCost' function below.
         *
         * The function is expected to return a DOUBLE.
         * The function accepts STRING_ARRAY messages as parameter.
         */

        public static double calculateTotalMessageCost(List<String> messages) {
            double finalCost = 0;
            for (String message : messages) {
                finalCost = finalCost + calculateMessageCost(message);
            }
            return finalCost;
        }

        private static double calculateMessageCost(String message) {
            if (!isOnlyBasicCharacters(message)) {
                return calculateCountMessages(MessageSize.OPERATOR_2_MESSAGE_SIZE_ucs_2_FORMAT, message) * SMS_TYPE_2_PRICE_USD;
            } else {
                final double price1 = calculateCountMessages(MessageSize.OPERATOR_1_MESSAGE_SIZE, message) * SMS_TYPE_1_PRICE_USD;
                final double price2 = calculateCountMessages(MessageSize.OPERATOR_2_MESSAGE_SIZE_GSM_7_FORMAT, message) * SMS_TYPE_2_PRICE_USD;
                return Math.min(price1, price2);
            }
        }

        private static int calculateCountMessages(MessageSize messageSize, String message) {
            int result = 0;
            for (int start = 0; start < message.length(); start += messageSize.size) {
                result ++;
            }
            return result;
        }

        private static boolean isOnlyBasicCharacters(String message) {
            return BASIC_CHARACTERS_PATTERN.matcher(message).matches();
        }

    }
