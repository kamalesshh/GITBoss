
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product" %>
<%@ taglib prefix="header" tagdir="/WEB-INF/tags/responsive/common/header"  %>
<%@ taglib prefix="footer" tagdir="/WEB-INF/tags/responsive/common/footer"  %>


<ul class="languagecurrencycomponent">
	<li><footer:languageSelector languages="${languages}" currentLanguage="${currentLanguage}" /></li>
	<li><footer:currencySelector currencies="${currencies}" currentCurrency="${currentCurrency}" /></li>
</ul>
