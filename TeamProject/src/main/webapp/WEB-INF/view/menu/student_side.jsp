<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
  margin: 0;
  padding: 0;
}
#sideName{
	margin: 0;
	height: 160px;
	width: 100%;
	background: rgba(14,14,114,0.7);
	color: white;
	font-size: 40px;
	font-weight: bold;
	text-align: left;
	line-height: 160px;
}
#sideMenu{
	height: 600px;
	width: 70%;
}
ul {
  list-style: none;
  text-align: left;
  padding: 0;
  margin: 0;
}
a {
  text-decoration: none;
}

.accordion-menu {
  width: 250px;
  height: 100%;
  border-radius: 4px;
  position: relative;
}
.accordion-menu li:last-child .dropdownlink {
  border-bottom: 0;
}
.dropdownlink {
	height: 60px;
	line-height: 60px;
	cursor: pointer;
	display: block;
	font-size: 20px;
	color: #191970;
	position: relative;
	-webkit-transition: all 0.4s ease-out;
	transition: all 0.4s ease-out;
}
/* .submenuItems {
  display: none;
  background: #f2f2f2;
  color: black;
  padding-left: 20px;
} */
.submenuItems{
}
.submenuItems li {
	color: black;
	transition: .4s;
	position: relative;
	top: 10px;
}
</style>
</head>
<body>
<input type="hidden"id="mainNum" name="mainNum" value=${menuSideDetailVO.mainNum }>
<input type="hidden" id="sideNum" name="sideNum" value=${menuSideDetailVO.sideNum }>
<input type="hidden" id="sideDetailNum" name="sideDetailNum" value=${menuSideDetailVO.sideDetailNum }> 
<div id="sideName">

</div> 

<div id="sideMenu" >
	<ul class="accordion-menu">
	  <li id = "aaaaa">
	  </li>
	</ul>
</div>
</body>
<script type="text/javascript">
/* $(function() {
	  var Accordion = function(el, multiple) {
	    this.el = el || {};
	    // more then one submenu open?
	    this.multiple = multiple || false;
	    
	    var dropdownlink = this.el.find('.dropdownlink');
	    dropdownlink.on('click',
	                    { el: this.el, multiple: this.multiple },
	                    this.dropdown);
	  };
	  
	  Accordion.prototype.dropdown = function(e) {
	    var $el = e.data.el,
	        $this = $(this),
	        //this is the ul.submenuItems
	        $next = $this.next();
	    
	    $next.slideToggle();
	    $this.parent().toggleClass('open');
	    
	    if(!e.data.multiple) {
	      //show only one menu at the same time
	      $el.find('.submenuItems').not($next).slideUp().parent().removeClass('open');
	    }
	  }
	  
	  var accordion = new Accordion($('.accordion-menu'), false);
	}) */
</script>
<script src="resources/js/student_side.js?ver=255"></script>
</html>