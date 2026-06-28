class KthLargest {
    static class MaxHeap{
        int[] val;
        int capacity;

        MaxHeap(int size){
            val=new int[size];
            capacity=0;
        }

        MaxHeap(int size,int[] nums){
               val=new int[size];
                Arrays.fill(val,(int)-1e9);
               int y=0;
               while(y<size && y<nums.length){
                val[y]=nums[y];
                y++;
               }
               heapify();

               while(y<nums.length){
                  addElement(nums[y++]);
               }
        }
    
        private int addElement(int p){
                  if(p<val[0])return val[0];
                
                int index=0;
                int le =val.length;
                val[0]=p;
                while(true){
                  int left=2*index+1;
                  int right=2*index+2;

                  int swap=-1;

                  if(left<le){
                    if(val[left]<val[index]){
                        swap=left;
                    }
                  }

                  if(right<le){
                   
                    if(swap!=-1){
                       
                     if(val[left]>val[right]){
                        swap=right;
                     } 
                  }else{

                    if(val[index]>val[right]){
                        swap=right;
                    }
                  }

                    }

                    if(swap==-1)break;

                    int tmp=val[index];
                    val[index]=val[swap];
                    val[swap]=tmp;

                    index=swap;

                }

                return val[0];

        }
    
    void heapify(){
        int le=val.length;

        for(int i=le/2-1;i>=0;i--){
            siftDown(i);
          }
          }

    private void siftDown(int i){
             int le=val.length;
             while(true){
                  int l = 2*i+1;
                  int r = 2*i+2;
                  int swap=i;

                  if(l<le && val[l]<val[swap])
                    swap=l;
                 if(r<le && val[r]<val[swap])
                    swap=r;

                if(swap==i)break;
                  
                  int tmp=val[i];
                  val[i]=val[swap];
                  val[swap]=tmp;
                  i=swap;
             }
    }



    }
    private MaxHeap mx;


    public KthLargest(int k, int[] nums) {
        mx=new MaxHeap(k,nums);
    }
    
    public int add(int val) {
        return mx.addElement(val);
    }
}
