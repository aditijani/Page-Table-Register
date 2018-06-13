package operatingSystem.Assignment2;

import java.util.Scanner;

/**
 * Created by parthgodhani on 12/4/17.
 */
public class Program {
    Scanner sc=new Scanner(System.in);
    short frames=0;
    short pages=0;
    short pCounter=0;
    short pageNo=0;
    short offset=0;
    short PAGE_SIZE=16;
    short MAX_PAGES=0x400;
    //short MAX_PAGES=8;
    short MAX_FRAMES=0x40;
    PageEntry pageEntry;
    MemorySupport memorySupport=new MemorySupport();

    public void init(){
        System.out.println("Enter No of pages");
        pages=(short)sc.nextInt();
        System.out.println("Enter No of frames");
        frames=(short)sc.nextInt();
        PageTable pageTable=new PageTable(pages,frames);
        for(int i=0;i<pages;i++){
           pCounter=(short)(Math.random()*MAX_PAGES*PAGE_SIZE);
           pageNo=(short)(pCounter>>3);
           offset=(short)(pCounter&0x7);
           pageEntry=pageTable.getPageEntrybyPageNo(pageNo);
           short frame_no=0,sec_no=0;

            //page entry already exist in table if part
           if(pageEntry!=null){

               if(pageEntry.VoI==true){
                   //page is valid--> print physical address

               }
               else{
                   //page is not valid

                   System.out.println("Page Fault at page number : " +pageNo);
                   if(pageTable.fifo.bufferFull()){
                       //no frames available

                       //read next page number to get space in queue and update valid bit in page table
                       short modifyPage=pageTable.fifo.read();
                       pageTable.updateVoIbit(modifyPage,false);

                       //prepare page table entry
                       frame_no=pageTable.getPageEntrybyPageNo(modifyPage).frameNo;
                       //add page table entry


                   }
                   else{
                       //frames available
                       frame_no=memorySupport.getNextAvailableFrame();
                   }
                   pageTable.updateFrameNo(pageNo,frame_no);
                   pageTable.updateVoIbit(pageNo,true);
                   pageTable.fifo.store(pageNo);


               }


           }


           //page entry not exist in table else part
           else{

               System.out.println("Page Fault at page number : " +pageNo);
                if(pageTable.fifo.bufferFull()){
                    //no frames available

                    //read next page number to get space in queue and update valid bit in page table
                    short modifyPage=pageTable.fifo.read();
                    pageTable.updateVoIbit(modifyPage,false);

                    //prepare page table entry
                    frame_no=pageTable.getPageEntrybyPageNo(modifyPage).frameNo;

                    //add page table entry


                }
                else{
                    //frames available
                    frame_no=memorySupport.getNextAvailableFrame();
                }
               pageTable.addEntry(new PageEntry(pageNo,frame_no,memorySupport.getNextFreeSec(),true));
               pageEntry=pageTable.getPageEntrybyPageNo(pageNo);
               pageTable.fifo.store(pageNo);

           }
            System.out.println("\t\tProgram Counter : " +pCounter + " and Physical Address: "+ ((pageEntry.frameNo*16)+offset));

        }
        pageTable.printFullPageTable();

    }
}
