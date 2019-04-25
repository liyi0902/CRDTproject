package demo1;

public class Letter implements Comparable<Letter>{

    int user_id;
    int char_index;
    char letter;
    //insert after this letter [user_id,char_index]
    int[] position;

    //好像没什么用
//    public Letter (int user_id,int char_index){
//        this.user_id=user_id;
//        this.char_index=char_index;
//    }

    //创建一个要插入的字符对象，该字符插入在文本的首位
    //创建一个要删除的字符对象，把字符也传入，方便观察。
    public Letter(int user_id, int char_index, char letter) {
        this.user_id = user_id;
        this.char_index = char_index;
        this.letter = letter;
    }

    //创建一个要插入的字符对象，该字符插入到文本的指定位置
    public Letter(int user_id,int char_index,char letter,int[] position){
        this.user_id = user_id;
        this.char_index = char_index;
        this.letter = letter;
        this.position=position;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getChar_index() {
        return char_index;
    }

    public void setChar_index(int char_index) {
        this.char_index = char_index;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    @Override
    public int compareTo(Letter letter) {
        //先按照char_index的大小排列
        if(this.char_index>letter.char_index){
            return 1;
        }else if (this.char_index<letter.char_index){
            return -1;
        }else {
            //再按照user_id的大小排列
            if(this.user_id>letter.user_id){
                return 1;
            }else if(this.user_id<letter.user_id){
                return -1;
            }
            else {
//                System.out.println("Something wrong, there are two letter' index are same.");
                return 0;
            }
        }
    }
}