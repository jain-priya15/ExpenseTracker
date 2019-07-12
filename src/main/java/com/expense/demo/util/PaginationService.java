package com.expense.demo.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class PaginationService {
	/**
	 * Calculate pageNumbers
	 * @param pageNumber
	 * @param totalPages
	 * @return
	 */
	public List<Integer> pagination(int pageNumber, int totalPages){
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            return pageNumbers;
            
        }
		return null;
		
	}

}
