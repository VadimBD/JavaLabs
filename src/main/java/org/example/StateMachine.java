package org.example;

import lombok.AllArgsConstructor;


public class StateMachine {
    private String searchWord;
    private String inputText;
    private Boolean found = false;
    private int indexS =0;
    private int currentIndex =0;
    private int count=0;
    private int maxCount=0;
    public StateMachine(String searchWord, String inputText) {
        this.searchWord = searchWord.toLowerCase();
        this.inputText = inputText.toLowerCase();
    }

    public String search() {

        if(inputText.length()==0||searchWord.length()==0){
            return "0";
        }
        if(inputText.charAt(currentIndex)== searchWord.charAt(indexS)) {
            indexS++;
            if(indexS==searchWord.length()) {
                found = true;
                indexS =0;
            }
            count++;
        }
        else {

            if(count>maxCount) {
                maxCount = count;
            }
            if(indexS>0)
            {
                currentIndex--;
            }
            indexS=0;
            count=0;

        }
        currentIndex++;
        if(currentIndex==inputText.length()) {
            return found ? "F" : String.valueOf(maxCount);
        }
        else
        {
            return search();
        }
    }
}
