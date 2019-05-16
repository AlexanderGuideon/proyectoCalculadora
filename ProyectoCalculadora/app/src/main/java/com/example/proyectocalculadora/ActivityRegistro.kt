class Register:Activity() {
  private val lblGotoLogin:TextView
  private val btnRegister:Button
  private val inputFullName:EditText
  private val inputEmail:EditText
  private val inputPassword:EditText
  private val registerErrorMsg:TextView
  fun onCreate(savedInstanceState:Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.register)
    inputFullName = findViewById(R.id.txtUserName) as EditText
    inputEmail = findViewById(R.id.txtEmail) as EditText
    inputPassword = findViewById(R.id.txtPass) as EditText
    btnRegister = findViewById(R.id.btnRegister) as Button
    registerErrorMsg = findViewById(R.id.register_error) as TextView
    btnRegister.setOnClickListener(object:View.OnClickListener() {
      fun onClick(view:View) {
        val name = inputFullName.getText().toString()
        val email = inputEmail.getText().toString()
        val password = inputPassword.getText().toString()
        val usuario = Usuario()
        usuario.setOnRegisterUsuario(object:OnRegisterUsuario() {
          fun onRegisterFinish(json:JSONObject, msg:String) {
            registerErrorMsg.setText("")
            val itemintent = Intent(this@Login, ActivityPrincipal::class.java)
            this@Register.startActivity(itemintent)
          }
          fun onRegisterFail(msg:String) {
            registerErrorMsg.setText(msg)
          }
          fun onRegisterException(e:Exception, msg:String) {
            registerErrorMsg.setText(msg)
          }
        })
        usuario.register(this@Register, name, email, password)
      }
    })
    lblGotoLogin = findViewById(R.id.link_to_login) as TextView
    lblGotoLogin.setOnClickListener(object:OnClickListener() {
      fun onClick(v:View) {
        val itemintent = Intent(this@Register, Login::class.java)
        this@Register.startActivity(itemintent)
      }
    })
  }
}
