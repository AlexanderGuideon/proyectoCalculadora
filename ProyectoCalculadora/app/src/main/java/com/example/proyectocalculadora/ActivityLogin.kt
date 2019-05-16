class Login:Activity() {
  private val lblGotoRegister:TextView
  private val btnLogin:Button
  private val inputEmail:EditText
  private val inputPassword:EditText
  private val loginErrorMsg:TextView
  fun onCreate(savedInstanceState:Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.login)
    inputEmail = findViewById(R.id.txtEmail) as EditText
    inputPassword = findViewById(R.id.txtPass) as EditText
    btnLogin = findViewById(R.id.btnLogin) as Button
    loginErrorMsg = findViewById(R.id.login_error) as TextView
    btnLogin.setOnClickListener(object:View.OnClickListener() {
      fun onClick(view:View) {
        val email = inputEmail.getText().toString()
        val password = inputPassword.getText().toString()
        val usuario = Usuario()
        usuario.setOnLoginUsuario(object:OnLoginUsuario() {
          fun onLoginWrong(msg:String) {
            loginErrorMsg.setText(msg)
          }
          fun onLoginCorrect(json:JSONObject, msg:String) {
            loginErrorMsg.setText("")
            val itemintent = Intent(this@Login, ActivityPrincipal::class.java)
            this@Login.startActivity(itemintent)
          }
        })
        usuario.login(this@Login, email, password)
      }
    })
    lblGotoRegister = findViewById(R.id.link_to_register) as TextView
    lblGotoRegister.setOnClickListener(object:OnClickListener() {
      fun onClick(v:View) {
        val itemintent = Intent(this@Login, Register::class.java)
        this@Login.startActivity(itemintent)
      }
    })
  }
}
