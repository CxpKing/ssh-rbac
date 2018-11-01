package com.hpeu.util;

import java.util.List;

/**
 * 分页工具类
 *
 * @Title: PaginationUtil<br />
 * @Descripton: 实现数据分页显示：可以上页，下页，前10页，后10页翻<br />
 * @Author: 姚臣伟<br />
 */
public class PaginationUtil<T> {
    private List<T> items;
    private int pageSize = 20;
    private int totalCount;
    private int pageNumber;
    private int[] indexes = new int[0];
    private int startIndex = 0;
    private int[] pages = new int[0];
    
    public PaginationUtil(){}
    
    public PaginationUtil(List<T> items, int totalCount, int startIndex, int pageSize){
    	this.pageSize = pageSize;
        setItems(items);
        setTotalCount(totalCount);
        setStartIndex(startIndex);
    }
    
    private void setTotalCount(int totalCount) {
        if(totalCount > 0){
            this.totalCount = totalCount;
            int count = totalCount / pageSize;
            if(totalCount % pageSize > 0){
                count++;
            }
            indexes = new int[count];
            for(int i = 0; i < count; i++){
                indexes[i] = pageSize * i;
            }
        }else{
            this.totalCount = 0;
        }
    }
    
    private void setStartIndex(int startIndex) {
        this.pageNumber = startIndex;
        if(totalCount <= 0){
            this.startIndex = 1;
        }else if(startIndex >= totalCount){
            this.startIndex = indexes[indexes.length - 1];
        }else if(startIndex < 1){
            this.startIndex = 1;
        }else{
            this.startIndex = indexes[startIndex / pageSize];
        }
    }
    
    public int getPrevPage(){
        int prevPage = pageNumber - 1;
        if(prevPage <= 1){
            prevPage = 1;
        }
        return prevPage;
    }
    
    public int getNextPage(){
        int nextPage = pageNumber + 1;
        if(nextPage >= getPageCount()){
            nextPage = getPageCount();
        }
        return nextPage;
    }
    
    public int getPrevTenPage(){
        int prevPage = pageNumber - 10;
        if(prevPage <= 1){
            prevPage = 1;
        }
        return prevPage;
    }
    
    public int getNextTenPage(){
        int nextPage = pageNumber + 10;
        if(nextPage >= getPageCount()){
            nextPage = getPageCount();
        }
        return nextPage;
    }
    
    public int[] getPages(){
        int first = 1;
        int end = pageNumber + 3;
        if(pageNumber -3 > 0){
            first = pageNumber -3;
        }
        if(end > getPageCount()){
            end = getPageCount();
        }
        if((end - first) < 6 && (first + 6) <= getPageCount()){
            end = first + 6;
        }
        if((end - first) < 6 && (end - 6) >= 1){
            first = end - 6;
        }
        int fornum = end - first + 1;
        pages = new int[fornum];
        for(int i = 0; i < fornum; i++){
            pages[i] = first;
            first++;
        }
        return pages;
    }
    
    public int getPageCount(){
        return indexes.length;
    }

    public int getNextIndex(){
        int nextIndex = this.startIndex + pageSize;
        return (nextIndex >= totalCount) ? this.startIndex : nextIndex;
    }
    
    public int getPrevIndex(){
        int prevIndex = this.startIndex - pageSize;
        return (prevIndex < 0) ? 0 : prevIndex;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getPageSize() {
        return pageSize;
    }
    
    public long getTotalCount() {
        return totalCount;
    }
    
    public int getPageNumber() {
		return pageNumber;
	}
    
    //显示分页页码
    public String getShowPage(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("<a class=\"page\" href=\"?page=1\">首页</a>");
        
        sb.append(" <a class=\"page\" href=\"?page=")
          .append(this.getPrevTenPage())
          .append("\">前十页</a>");
        
        sb.append(" <a class=\"page\" href=\"?page=")
          .append(this.getPrevPage())
          .append("\">上页</a>");
        
        for(int i=0; i<this.getPages().length; i++){
            if(this.pageNumber == this.getPages()[i]){
                sb.append(" <a class=\"over\" title=\"第")
                  .append(this.getPages()[i])
                  .append("页\" href=\"javascript:void(0);\">")
                  .append(this.getPages()[i])
                  .append("</a>");
            }else{
                sb.append(" <a class=\"page\" title=\"第")
                  .append(this.getPages()[i])
                  .append("页\" href=\"?page=")
                  .append(this.getPages()[i])
                  .append("\">")
                  .append(this.getPages()[i])
                  .append("</a>");
            }
        }
        
        sb.append(" <a class=\"page\" href=\"?page=")
          .append(this.getNextPage())
          .append("\">下页</a>");
        
        sb.append(" <a class=\"page\" href=\"?page=")
          .append(this.getNextTenPage())
          .append("\">后十页</a>");
        
        sb.append(" <a class=\"page\" href=\"?page=")
          .append(this.getPageCount())
          .append("\">末页</a>");
        
        sb.append(" <span class=\"info\">&nbsp;共&nbsp;<strong>")
          .append(this.getTotalCount())
          .append("</strong>&nbsp;条，每页<strong>")
          .append(this.getPageSize())
          .append("/")
          .append(this.getPageCount())
          .append("</strong>页</span>");

        return sb.toString();
    }
    
    /**
     * 使用Post提交，得到分页条导航信息
     * @return
     */
    public String getNavgiation(){
    	StringBuffer sb=new StringBuffer();
    	sb.append("<div class='page-navgiation'>");
    	
    	sb.append("<a class=\"page\" data-page=\"1\">首页</a>");
    	
    	sb.append(" <a class=\"page\" data-page=\"")
    	  .append(this.getPrevTenPage())
    	  .append("\">前十页</a>");
    	
    	sb.append(" <a class=\"page\" data-page=\"")
    	  .append(this.getPrevPage())
    	  .append("\">上页</a>");
    	
    	for(int i : this.getPages()){
    		if(this.pageNumber == i){
    			sb.append(" <a class=\"over\">")
    			  .append(i)
    			  .append("</a>");
    		}else{
    			sb.append(" <a class=\"page\" title=\"第")
    			  .append(i)
    			  .append("页\" data-page=\"")
    			  .append(i)
    			  .append("\">")
    			  .append(i)
    			  .append("</a>");
    		}
    	}
    	
    	sb.append(" <a class=\"page\" data-page=\"")
    	  .append(this.getNextPage())
    	  .append("\">下页</a>");
    	
    	sb.append(" <a class=\"page\" data-page=\"")
    	  .append(this.getNextTenPage())
    	  .append("\">后十页</a>");
    	
    	sb.append(" <a class=\"page\" data-page=\"")
    	  .append(this.getPageCount())
    	  .append("\">末页</a>");
    	
		sb.append(" <span class=\"info\">&nbsp;共&nbsp;<strong>")
		  .append(this.getTotalCount())
		  .append("</strong>&nbsp;条，每页<strong>")
		  .append(this.getPageSize())
		  .append("/")
		  .append(this.getPageCount())
		  .append("</strong>页</span>");
    	
    	sb.append("<input name=\"page\" type=\"hidden\" id=\"page\" value=\"")
    	  .append(this.pageNumber)
    	  .append("\" />")
    	  .append("</div>");
    	
        return sb.toString();
    }

}
