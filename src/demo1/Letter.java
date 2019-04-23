package demo1;

public class Letter implements Comparable<Letter>{

    int user_id;
    int char_index;
    char letter;
    //insert after this letter [user_id,char_index]
    int[] position;

    //创建一个要删除的字符对象
    public Letter (int user_id,int char_index){
        this.user_id=user_id;
        this.char_index=char_index;
    }

    //创建一个要插入的字符对象，该字符插入在文本的首位
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

    @Override
    public int compareTo(Letter letter) {
        if(this.char_index>letter.char_index){
            return 1;
        }else if (this.char_index<letter.char_index){
            return -1;
        }else {
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