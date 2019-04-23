package demo1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Text {

    public static List<Letter> list = new LinkedList<>();

    public static void main(String[] args) {
        initialList();
        List<Letter> addList=getPositiveList();
        insertLetterList(addList);
        printText(list);
        List<Letter> removeList=getNegativeList();
        deleteLetterList(removeList);
        printText(list);
    }

    public static void printText(List<Letter> list){
        for (Letter l : list
        ) {
            System.out.print(l.letter);
        }
        System.out.println();
    }

    public static void initialList() {
        list.add(new Letter(1, 1, 'h'));
        list.add(new Letter(1, 2, 'e'));
        list.add(new Letter(1, 3, 'l'));
        list.add(new Letter(1, 4, 'l'));
        list.add(new Letter(1, 5, 'o'));
    }

    public static void insertLetterIntoList(Letter letter) {
        if(letter.position!=null){
            Letter positionLetter = getLetterObj(letter.position);
            int position = list.indexOf(positionLetter) + 1;
            list.add(position, letter);
        }else {
            //插入到文本的起始位置
            list.add(0,letter);
        }

    }
    public static void removeLetterFromList(Letter letter){
        Letter remove_letter=getLetterObj(letter);
        list.remove(remove_letter);
    }

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

    public static Letter getLetterObj(Letter letter){
        for (Letter l:list
             ) {
            if(l.user_id==letter.user_id && l.char_index==letter.char_index){
                return l;
            }
        }
        System.out.println("删除字符的位置错误，要删除的字符不存在");
        return null;
    }

    public static void insertLetterList(List<Letter> list){
        for (Letter letter:list
             ) {
            insertLetterIntoList(letter);
        }
    }
    public static void deleteLetterList(List<Letter> list){
        for (Letter letter:list){
            removeLetterFromList(letter);
        }
    }


    public static List<Letter> getPositiveList(){
        List<Letter> list=new LinkedList<>();
        list.add(new Letter(2,6,'A',new int[]{1,1}));
        list.add(new Letter(3,7,'B',new int[]{3,6}));
        list.add(new Letter(2,8,'A',new int[]{1,4}));
        list.add(new Letter(2,9,'A',new int[]{2,8}));
        list.add(new Letter(2,7,'A',new int[]{2,6}));
        list.add(new Letter(3,6,'B',new int[]{1,1}));
        list.add(new Letter(1,6,'~'));
        list.add(new Letter(1,7,'W',new int[]{1,6}));
        Collections.sort(list);
        return list;
    }
//
    public static List<Letter> getNegativeList(){
        List<Letter> list=new LinkedList<>();
        list.add(new Letter(1,6));
        list.add(new Letter(1,5));
        return list;
    }

}
