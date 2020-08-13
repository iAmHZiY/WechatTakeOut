function checkMail(mail){
    var re = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
    return re.test(mail);
}

function checkUid(uid) {
    var re = /^[a-zA-Z]([-_a-zA-Z0-9]{5,20})$/;
    return re.test(uid);
}