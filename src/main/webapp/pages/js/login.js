$(function () {
    $("#pics").click(function () {
        var date = new Date().getTime();
        $("#pics").prop("src", "/BHU/auth/code?data=" + date)
    })
})


$("#submit_login").click(function () {

    var incode = $("#inputCheckCode").val();
    $.ajax({
        url: '/BHU/auth/judgeCode',
        data: {
            incode: incode
        },
        success: function (data) {
            if (data != "false") {
                var account = $("#inputUserid").val();
                var password = $("#inputPassword").val();
                $.ajax({
                    url: '/BHU/user/login',
                    data: {
                        account: account,
                        password: password
                    },
                    success: function (data) {
                        if (data == "") {
                            alert("帐号或密码错误");
                        } else {
                            document.location.href = "index.html";
                        }
                    }
                })
            } else {
                alert("验证码有误！");
                return;
            }
        }
    })


});