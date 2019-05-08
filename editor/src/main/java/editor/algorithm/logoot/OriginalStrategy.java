//package editor.algorithm.logoot;
//
//import java.util.ArrayList;
//import java.util.Random;
//
///**
// * use the method in original paper to generate
// */
//public class OriginalStrategy extends Strategy{
//
////    @Override
////    public ArrayList<PositionIdentifier> generatePositionIdentifiers(PositionIdentifier p, PositionIdentifier q, int n){
////        ArrayList<PositionIdentifier> list=new ArrayList<>(n);
////        int index = 0;
////        int interval = 0;
////        while (interval < n) {
////            index++;
////            interval = prefix(q, index) - prefix(p, index);
////        }
////        int step = interval / n;
////        int r = prefix(p, index);
////        for (int j = 0; j < n; j++) {
////            list.add(construct(r + new Random().nextInt(step) + 1, p, q));
////            r = r + step;
////        }
////        return list;
////    }
//
//
////    private int prefix(ArrayList<Identifier> p, int i) {
////        StringBuilder s = new StringBuilder();
////        for (int j = 0; j < i; j++) {
////            if (j < p.size())
////                digits = digits + p.get(j).getDigit();
////            else
////                digits = digits + "0";
////        }
////        return Integer.parseInt(digits);
////
////
////
////    }
//
//
//
//
////    @Override
////    ArrayList<Identifier> generatePositionIdentifiers(ArrayList<Identifier> p, ArrayList<Identifier> q) throws Exception {
////        ArrayList<Identifier> list=new ArrayList<>(1);
////        int index = 0;
////        int interval = 0;
////        while (interval == 0) {
////            index++;
////            interval = prefix(q, index) - prefix(p, index);
////        }
////        int step = interval;
////        int r = prefix(p, index);
////        for (int j = 0; j < n; j++) {
////            list.add(construct(r + new Random().nextInt(step) + 1, p, q));
////            r = r + step;
////        }
////        list=constructPosition()
////
////        return list;
////
////    }
//
//
//
//}
