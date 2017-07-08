/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuentes_practicas;
/**
 *
 * @author jsepulveda
 */
public class heap_Sort{
    public static void main(String a[])
    {
          int i;
          int arr[] = {13,21,16,24,31,19,68,65,26,32};
          System.out.println("Heap Sort");   
          System.out.println("\n---------------\n");
          System.out.println("\nUnsorted array\n\n");
          for (i = 0; i < arr.length; i++)
                System.out.print(" "+arr[i]);
          for(i=arr.length; i>1; i--)
          {
                fnSortHeap(arr, i - 1);
          }
          System.out.println("Sorted array");
          System.out.println("\n---------------\n");
          for (i = 0; i < arr.length; i++)
          {
                System.out.print(" "+arr[i]);
          }
          public void fnSortHeap(int arr[], int arr2){
                int i, o;
                int lCh, rCh, mCh, root, tmp;
                root = (arr2-1)/2;

                for(o = root; o >= 0; o--)
                {
                      for(i=root;i>=0;i--)
                      {
                            lCh = (2*i)+1;
                            rCh = (2*i)+2;
                            if((lCh <= arr2) && (rCh <= arr2))
                            {
                                  if(arr[rCh] >= arr[lCh])
                                  {
                                        mCh = rCh;
                                  }
                                  else
                                  {
                                        mCh = lCh;
                                  }
                            }
                            else
                            {
                                  if(rCh > arr2)
                                  {
                                        mCh = lCh;
                                  }
                                  else
                                  {
                                        mCh = rCh;
                                  }
                            }

                            if(arr[i] < arr[mCh])
                            {
                                  tmp = arr[i];
                                  arr[i] = arr[mCh];
                                  arr[mCh] = tmp;
                            }
                      }
                }
                tmp = arr[0];
                arr[0] = arr[arr2];
                arr[arr2] = tmp;
                return;
          }
    }
}
