package advertise.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class AdvertisePaging {
	   private int currentPage;
	   private int pageBlock;
	   private int pageSize;
	   private int totalA;
	   private StringBuffer pagingHTML;
	   
	   //서치페이징
	   
	   public void makePagingHTML() {
		   
	      pagingHTML = new StringBuffer();
	      
	      int totalP = (totalA+pageSize-1)/pageSize;
	      
	      int startPage = (currentPage-1) / pageBlock * pageBlock + 1;
	      int endPage = startPage + pageBlock - 1;
	      if(endPage > totalP) endPage = totalP;
	      
	      if(startPage > pageBlock) 
	         pagingHTML.append("<li class='page-item'><a class='page-link' onclick='adPaging("+(startPage-1)+")'>이전</a></li>");

	      for(int i =startPage; i<=endPage; i++) {
	         if(i==currentPage) {
	            pagingHTML.append("<li class='page-item active' aria-current='page'><a class='page-link' onclick='adPaging("+i+")'>"+i+"</a></li> ");
	         }else {
	            pagingHTML.append("<li class='page-item' ><a class='page-link' onclick='adPaging("+i+")'>"+i+"</a></li>");
	         }//else
	      }//for
	   
	      if(endPage < totalP) 
	         pagingHTML.append("<li class='page-item'><a class='page-link' onclick='adPaging("+(endPage+1)+")'>다음</a></li>");
	   }
	   
	}
