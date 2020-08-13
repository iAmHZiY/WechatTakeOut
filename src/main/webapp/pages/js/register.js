var uid;
var email;
var flag = false;

function existUid() {
        $.ajax({
            url:"/BHU/user/checkAccount",
            data:{
                account:$("#inputAccount").val()
            },success:function (data) {
                if(data==null || data ==""){
                    account = $("#inputAccount").val();
                    $("#uidMsg").html("");
                } else {
                    $("#uidMsg").html(data);
                }
            }
        })
}


$("#submit_register").click(function () {
    var account = $("#inputAccount").val();
    var password1 = $("#inputPassword1").val();
    var password2 = $("#inputPassword2").val();
    if (password1 == "") {
        alert("请先输入密码");
        return;
    }
    if (password1.length < 6) {
        alert("密码不得低于6位");
        return;
    }
    if (password1 != password2) {
        alert("两次密码不相同，请重新输入");
        $("#inputPassword1").val("");
        $("#inputPassword2").val("");
    } else {
            $.ajax({
                url: "/BHU/user/saveUser",
                data: {
                    account: account,
                    password: password1
                },
                success: function (data) {
                    if (data == "success") {
                        document.location.href = "index.html";
                    }
                }
            })

    }
})

function sendEmail() {
    if (flag == true){
        $.ajax({
            url: "/BHU/mail/sendMail",
            data: {
                email: $("#inputEmail").val()
            },
            success:function () {
                alert("邮箱验证码已经发送,5分钟内有效");
            }
        })
    }else {
        alert("请重新检查邮箱")
    }
}

function checkEmail() {
    $.ajax({
        url: "/BHU/mail/judgeMail",
        data: {
            inCode: $("#inputEmailCheck").val()
        },
        success: function (data) {
            if (data != "验证成功") {
                alert(data)
            }
        }
    })
}

function check() {
    $.ajax({
        url: "/BHU/user/checkEmail",
        data: {
            email: $("#inputEmail").val()
        },
        success: function (data) {
            if (data == null || data == "") {
                if (checkMail($("#inputEmail").val())) {
                    email =  $("#inputEmail").val();
                    flag = true;
                } else {
                    alert("请输入正确的邮箱")
                }
            } else {
                alert(data);
            }
        }
    })
}