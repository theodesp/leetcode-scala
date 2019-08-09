object DefangingIP extends App {
  def defangIPaddr(address: String): String = {
    address.replaceAll("\\.", "\\[\\.\\]")
  }
}
