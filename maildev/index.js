import MailDev from 'maildev'

const maildev = new MailDev()

maildev.listen()

maildev.on("new", function (email) {
    console.log(email)
})