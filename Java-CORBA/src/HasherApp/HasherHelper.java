package HasherApp;


/**
* HasherApp/HasherHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Hasher.idl
* Friday, 19 March, 2021 2:39:38 PM IST
*/

abstract public class HasherHelper
{
  private static String  _id = "IDL:HasherApp/Hasher:1.0";

  public static void insert (org.omg.CORBA.Any a, HasherApp.Hasher that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static HasherApp.Hasher extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (HasherApp.HasherHelper.id (), "Hasher");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static HasherApp.Hasher read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_HasherStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, HasherApp.Hasher value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static HasherApp.Hasher narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof HasherApp.Hasher)
      return (HasherApp.Hasher)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      HasherApp._HasherStub stub = new HasherApp._HasherStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static HasherApp.Hasher unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof HasherApp.Hasher)
      return (HasherApp.Hasher)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      HasherApp._HasherStub stub = new HasherApp._HasherStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
