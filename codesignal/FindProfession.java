/*https://app.codesignal.com/interview-practice/task/FwAR7koSB3uYYsqDp/description*/
String findProfession(int level, int pos) {
    boolean inverted = false;
    
    while (level > 1) {
        if (pos % 2 == 0) {
            inverted = !inverted;
        }
        
        pos = (pos + 1) / 2;
        level--;
    }
    
    return inverted? "Doctor" : "Engineer";

}
