public class parseStringData {

    class Solution {
        public String solution(String S) {
            String[] splitString = S.split(" ");
            StringBuilder sb = new StringBuilder();
            // data store vars
            int musicData = 0;
            int moviesData = 0;
            int otherData = 0;
            int imageData = 0;
            try {
                for(int i = 0; i < splitString.length; i += 2){
                    // made a mistake here with i += 2 causing wrong data to be taken in
                    String file = splitString[i];
                    String fileType = fileIdentifierHelper(file);

                    String data = splitString[i + 1];
                    int len = data.length();
                    String newData = data.replace("b", "");
                    int numbericData = Integer.parseInt(newData);

                    if(fileType == "music"){
                        musicData += numbericData;

                    }else if(fileType == "movies"){
                        moviesData += numbericData;

                    }else if(fileType == "other"){
                        otherData += numbericData;

                    }else if(fileType == "image"){
                        imageData += numbericData;
                    }

                }
            }catch(Exception e){System.out.println(e);}

            sb.append("music " + musicData +"b");
            sb.append("\n");
            sb.append("images " + imageData +"b");
            sb.append("\n");
            sb.append("movies " + moviesData +"b");
            sb.append("\n");
            sb.append("other " + otherData +"b");

            return sb.toString();

        }


        public String fileIdentifierHelper(String s){
            //extensions
            String[] music = {".mp3", ".aac", ".flac"};
            String[] images = {".jpg", ".bmp", ".gif"};
            String[] movies = {".mp4", ".avi", ".mkv"};
            String[] other = {".7z", ".txt", ".zip"};

            String dataType="";
            try{
                for(String extension : music){
                    if(s.contains(extension)){
                        dataType = "music";
                    }
                }

                for(String extension : images){
                    if(s.contains(extension)){
                        dataType = "images";
                    }
                }

                for(String extension : movies){
                    if(s.contains(extension)){
                        dataType = "movies";
                    }
                }

                for(String extension : other){
                    if(s.contains(extension)){
                        dataType = "other";
                    }
                }
            }catch(Exception e){System.out.println(e);}

            return dataType;
        }
    }

}
