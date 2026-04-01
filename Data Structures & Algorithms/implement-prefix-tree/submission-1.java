class PrefixTree {

    class Prefix{
	Prefix[] arr ;
	boolean iswordended = false;
	Prefix(){
	arr = new Prefix[26];
	}

	public Prefix get(char c){
	   int index = c-'a';
	   if(arr[index] == null){
		arr[index] = new Prefix();
	   }
	   return arr[index];	
	}

	public void set(){
	   iswordended = true;
	}

	public boolean isContain(char c){
	   int index = c-'a';
	   if(arr[index] == null){
		return false;
	   }
	   else{
		return true;
	   }
	}

    }
    Prefix list;
    public PrefixTree() {
         list = new Prefix();
    }


    public void insert(String word) {
	   dfs(word,0,list);

    }
    public void dfs(String word,int index,Prefix arr){
	 if(word.length() == index){
		arr.set();
		return;
	}
	Prefix newtree = arr.get(word.charAt(index));
	dfs(word,index+1,newtree);
    }


    public boolean search(String word) {
	return searchdfs(word,0,list);

    }

    public boolean searchdfs(String word,int index,Prefix arr){
	 if(word.length() == index){
		return arr.iswordended;
	}
	if(arr.isContain(word.charAt(index))){
		return searchdfs(word,index+1,arr.get(word.charAt(index)));
	}
	else{
		return false;
	}
    }

    public boolean startsWith(String prefix) {
		return searchstartsWithdfs(prefix,0,list);
    }

    public boolean searchstartsWithdfs(String word,int index,Prefix arr){
	 if(word.length() == index){
		return true;
	}
	if(arr.isContain(word.charAt(index))){
		return searchstartsWithdfs(word,index+1,arr.get(word.charAt(index)));
	}
	else{
		return false;
	}
    }
}
