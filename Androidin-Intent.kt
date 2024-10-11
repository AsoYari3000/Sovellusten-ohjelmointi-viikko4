fun Home() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize().padding(10.dp))
    {
        Text("Home",
            fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.Center)
        )
        Button(onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            context.startActivity(intent)
        }){
                Text(text="Goodle")
        }
        Button(onClick = {
            val intent= Intent(Intent.ACTION_DIAL).apply { data = Uri.parse("tel:040-123456") }
            context.startActivity(intent)
        })
        {
            Text(text = "Soita 040-123456")
        }
        Button(onClick = {
            val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
                putExtra(AlarmClock.EXTRA_HOUR, 8)
                putExtra(AlarmClock.EXTRA_MINUTES, 30)
                putExtra(AlarmClock.EXTRA_MESSAGE, "Alarm klo 8:30")
            }
            if (intent.resolveActivity(context.packageManager) != null) {
                context.startActivity(intent)
            }
        }){
            Text(text = "Set alarm")
        }
        Button(onClick ={
            val uri = Uri.parse("geo:0,0?q=Osuuskunnankatu+1")
            val mapIntent = Intent(Intent.ACTION_VIEW).apply { data = uri }
            context.startActivity(mapIntent)
        } )
        {
            Text(text = "Show map")
        }
    }
}
