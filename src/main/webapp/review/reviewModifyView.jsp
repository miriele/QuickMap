<%@page import="review.ReviewDataBean"%>
<%@page import="review.ReviewDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_review.jsp"%>
<h2> ${page_review_view} </h2>

<form method="post" action="reviewdelete.do" onsubmit="return deleteReview()">
	<input type="hidden" name="review_id" value="${dto.review_id}">
	<table>
		<tr>
			<td> ${dto.office_name} </td>
		</tr>
		<tr>
			<td> ${dto.review_star} </td>
		</tr>
		<tr>
			<th> ${dto.review_data} </th>
		</tr>
		<tr>
			<th colspan=2>
				<input type="button" value="${btn_modify}"
					onclick="location='reviewmodify.do?reviewId=${dto.review_id}&nextPage=reviewlist'">
				<input type="submit" value="${btn_delete}">
			</th>
		</tr>
	</table>
</form>

<script type="text/javascript">
	function deleteReview() {
		if(confirm("정말 삭제하시겠습니까?") == true) {
			return true;
		} else {
			return false;
		}
	}
</script>