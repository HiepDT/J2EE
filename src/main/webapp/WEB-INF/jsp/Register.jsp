<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Sign On</title>
</head>
CAI DCMMM
<body>
<s:form action="Register">
    <s:text name="msg"/>
    <s:textfield name="username"/>
    <s:password name="password"/>
    <s:select list="userType.userTypes"/>
    <s:text name="gadget"/>
    <s:text name="autoScanned"/>
    <s:checkbox name="jboss" label="UseEJB (loi deo chay duoc)"/>
    <s:submit/>
</s:form>
</body>
</html>
