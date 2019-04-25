package demo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Text {

    //当前在文本框中的letter list
    public static List<Letter> list = new LinkedList<>();
    //插入的letter list
    public static List<Letter> insertList = new LinkedList<>();
    //删除的letter list
    public static List<Letter> removeList = new LinkedList<>();


//    public static void main(String[] args) {
//        initialList();
//        System.out.println("本地原始list");
//        printText(list);
//
//        List<Letter> addList = getPositiveList();
//        insertLetterList(addList);
//        System.out.println("插入一组letter后的结果");
//        printText(list);
//
//
//        List<Letter> removeList = getNegativeList();
////        deleteLetterList(removeList);
////        System.out.println("删除一组letter后的结果");
////        printText(list);
//
//        String js = letterListToJson(removeList);
//        System.out.println("把letter list转换成json：");
//        System.out.println(js);
//        System.out.println("把json再转回letter list");
//        jsonToRemoveList(js);
//        deleteLetterList(removeList);
//        printText(list);
//
////        jsonToInsertList(js);
////        printText(insertList);
//    }

    public static void printText(List<Letter> list) {
        for (Letter l : list
        ) {
            System.out.print(l.letter);
        }
        System.out.println();
        System.out.println();
    }

    public static void mergeMessage(String pos,String neg){
        jsonToInsertList(pos);
        jsonToRemoveList(neg);
        insertLetterList(insertList);
        deleteLetterList(removeList);
    }


    public static void initialList() {
        list.add(new Letter(1, 1, 'h'));
        list.add(new Letter(1, 2, 'e'));
        list.add(new Letter(1, 3, 'l'));
        list.add(new Letter(1, 4, 'l'));
        list.add(new Letter(1, 5, 'o'));
    }

    public static String getTestJsonStringPos(){
        List<Letter> list = new LinkedList<>();
        list.add(new Letter(1, 6, '~'));
        list.add(new Letter(2, 9, 'A', new int[]{2, 8}));
        list.add(new Letter(2, 6, 'A', new int[]{1, 1}));
        list.add(new Letter(3, 7, 'B', new int[]{3, 6}));
        list.add(new Letter(2, 8, 'A', new int[]{1, 4}));
        list.add(new Letter(2, 7, 'A', new int[]{2, 6}));
        list.add(new Letter(3, 6, 'B', new int[]{1, 1}));
        list.add(new Letter(1, 7, 'W', new int[]{1, 6}));
        return letterListToJson(list);
    }

    public static String getTestJsonStringNeg(){
        List<Letter> list = new LinkedList<>();
        list.add(new Letter(1, 6,'~'));
        list.add(new Letter(1, 5,'o'));
        list.add(new Letter(1, 7,'W'));
        list.add(new Letter(3, 7, 'B'));
        list.add(new Letter(3, 6,'B'));
        return letterListToJson(list);
    }

    /**
     * 插入一个letter对象到当前的list中
     *
     * @param letter
     */
    public static void insertLetterIntoList(Letter letter) {
        System.out.println("正在插入："+letter.letter);
        if (letter.position != null) {
            Letter positionLetter = getLetterObj(letter.position);
            int position = list.indexOf(positionLetter) + 1;
            list.add(position, letter);
        } else {
            //插入到文本的起始位置
            list.add(0, letter);
        }
    }

    /**
     * 从list中删除一个letter对象
     *
     * @param letter
     */
    public static void removeLetterFromList(Letter letter) {
        Letter remove_letter = getLetterObj(letter);
        list.remove(remove_letter);
        System.out.println("正在删除:"+letter.letter);
    }

    /**
     * 通过position信息，定位一个letter对象（用来定位插入位置）
     *
     * @param position
     * @return
     */
    public static Letter getLetterObj(int[] position) {
        for (Letter l : list
        ) {
            if (l.user_id == position[0] && l.char_index == position[1]) {
                return l;
            }
        }
        System.out.println("插入字符的位置错误，该位置不存在。");
        return null;
    }

    /**
     * 通过传入的letter对象，找到list中与之相等的letter对象（用来定位删除的letter）
     *
     * @param letter
     * @return
     */
    public static Letter getLetterObj(Letter letter) {
        for (Letter l : list
        ) {
            if (l.user_id == letter.user_id && l.char_index == letter.char_index) {
                return l;
            }
        }
        System.out.println("删除字符的位置错误，要删除的字符不存在");
        return null;
    }

    /**
     * 把一组letter（list）插入到本地的letter list中，该方法会对插入的letter重新排序，保证一致性。
     *
     * @param list
     */
    public static void insertLetterList(List<Letter> list) {
        Collections.sort(list);
        for (Letter letter : list
        ) {
            insertLetterIntoList(letter);
        }
    }

    /**
     * 从本地的letter list中删除一组letter （list）
     *
     * @param list
     */
    public static void deleteLetterList(List<Letter> list) {
        for (Letter letter : list) {
            removeLetterFromList(letter);
        }
    }


    public static List<Letter> getPositiveList() {
        List<Letter> list = new LinkedList<>();
        list.add(new Letter(1, 6, '~'));
        list.add(new Letter(2, 9, 'A', new int[]{2, 8}));
        list.add(new Letter(2, 6, 'A', new int[]{1, 1}));
        list.add(new Letter(3, 7, 'B', new int[]{3, 6}));
        list.add(new Letter(2, 8, 'A', new int[]{1, 4}));
        list.add(new Letter(2, 7, 'A', new int[]{2, 6}));
        list.add(new Letter(3, 6, 'B', new int[]{1, 1}));
        list.add(new Letter(1, 7, 'W', new int[]{1, 6}));
        return list;
    }

    public static List<Letter> getNegativeList() {
        List<Letter> list = new LinkedList<>();
        list.add(new Letter(1, 6,'~'));
        list.add(new Letter(1, 5,'o'));
        list.add(new Letter(1, 7,'W'));
        list.add(new Letter(3, 7, 'B'));
        list.add(new Letter(3, 6,'B'));
        return list;
    }

    /**
     * 供Message类调用，返回编码后的insertList（JSON）字符串。
     * @return
     */
    public static String getPositiveField(){
        return letterListToJson(insertList);
    }

    /**
     * 供Message类调用，返回编码后的removeList（JSON）字符串
     * @return
     */
    public static String getNegativeField(){
        return letterListToJson(removeList);
    }

    /**
     * 把letterlist转换成json字符串
     *
     * @param list
     * @return
     */
    public static String letterListToJson(List<Letter> list) {
        JSONArray jsonArray = new JSONArray(list);
        return jsonArray.toString();
    }

    public static void jsonToInsertList(String jsonStirng) {
        insertList.clear();
        JSONArray jsonArray = new JSONArray(jsonStirng);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject j = jsonArray.getJSONObject(i);
            insertList.add(jsonToLetter(j));
        }
    }

    public static void jsonToRemoveList(String jsonStirng) {
        removeList.clear();
        JSONArray jsonArray = new JSONArray(jsonStirng);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject j = jsonArray.getJSONObject(i);
            removeList.add(jsonToLetter(j));
        }
    }

    /**
     * 解析jsonObject成一个Letter对象
     *
     * @param jsonObject
     * @return
     */
    public static Letter jsonToLetter(JSONObject jsonObject) {
        int user_id = jsonObject.getInt("user_id");
        int char_index = jsonObject.getInt("char_index");

        char letter = '\0';
        String letter_field = jsonObject.getString("letter");
        if (!letter_field.equals("\u0000")) {
            letter = letter_field.charAt(0);
        }

        int[] position = null;
        if (!jsonObject.isNull("position")) {
            JSONArray jsonArray_position = (JSONArray) jsonObject.get("position");
            int pos0 = (int) jsonArray_position.get(0);
            int pos1 = (int) jsonArray_position.get(1);
            position = new int[]{pos0, pos1};
        }

        if (position != null) {
            return new Letter(user_id, char_index, letter, position);
        }
//        else if (letter != '\0') {
//            return new Letter(user_id, char_index, letter);
//        }
        else {
            return new Letter(user_id, char_index,letter);
        }
    }

}
