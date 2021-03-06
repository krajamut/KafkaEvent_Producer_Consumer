/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.kiruthika.pojoavro.v2;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class SwipeEvents extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -779968014363065539L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"SwipeEvents\",\"namespace\":\"com.kiruthika.pojoavro.v2\",\"fields\":[{\"name\":\"dept\",\"type\":[\"null\",\"string\"]},{\"name\":\"empNo\",\"type\":{\"type\":\"int\",\"java-class\":\"java.lang.Integer\"}},{\"name\":\"eventType\",\"type\":[\"null\",\"string\"]},{\"name\":\"swipeTime\",\"type\":[\"null\",\"string\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<SwipeEvents> ENCODER =
      new BinaryMessageEncoder<SwipeEvents>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<SwipeEvents> DECODER =
      new BinaryMessageDecoder<SwipeEvents>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<SwipeEvents> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<SwipeEvents> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<SwipeEvents> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<SwipeEvents>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this SwipeEvents to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a SwipeEvents from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a SwipeEvents instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static SwipeEvents fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.CharSequence dept;
   private int empNo;
   private java.lang.CharSequence eventType;
   private java.lang.CharSequence swipeTime;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public SwipeEvents() {}

  /**
   * All-args constructor.
   * @param dept The new value for dept
   * @param empNo The new value for empNo
   * @param eventType The new value for eventType
   * @param swipeTime The new value for swipeTime
   */
  public SwipeEvents(java.lang.CharSequence dept, java.lang.Integer empNo, java.lang.CharSequence eventType, java.lang.CharSequence swipeTime) {
    this.dept = dept;
    this.empNo = empNo;
    this.eventType = eventType;
    this.swipeTime = swipeTime;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return dept;
    case 1: return empNo;
    case 2: return eventType;
    case 3: return swipeTime;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: dept = (java.lang.CharSequence)value$; break;
    case 1: empNo = (java.lang.Integer)value$; break;
    case 2: eventType = (java.lang.CharSequence)value$; break;
    case 3: swipeTime = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'dept' field.
   * @return The value of the 'dept' field.
   */
  public java.lang.CharSequence getDept() {
    return dept;
  }


  /**
   * Sets the value of the 'dept' field.
   * @param value the value to set.
   */
  public void setDept(java.lang.CharSequence value) {
    this.dept = value;
  }

  /**
   * Gets the value of the 'empNo' field.
   * @return The value of the 'empNo' field.
   */
  public int getEmpNo() {
    return empNo;
  }


  /**
   * Sets the value of the 'empNo' field.
   * @param value the value to set.
   */
  public void setEmpNo(int value) {
    this.empNo = value;
  }

  /**
   * Gets the value of the 'eventType' field.
   * @return The value of the 'eventType' field.
   */
  public java.lang.CharSequence getEventType() {
    return eventType;
  }


  /**
   * Sets the value of the 'eventType' field.
   * @param value the value to set.
   */
  public void setEventType(java.lang.CharSequence value) {
    this.eventType = value;
  }

  /**
   * Gets the value of the 'swipeTime' field.
   * @return The value of the 'swipeTime' field.
   */
  public java.lang.CharSequence getSwipeTime() {
    return swipeTime;
  }


  /**
   * Sets the value of the 'swipeTime' field.
   * @param value the value to set.
   */
  public void setSwipeTime(java.lang.CharSequence value) {
    this.swipeTime = value;
  }

  /**
   * Creates a new SwipeEvents RecordBuilder.
   * @return A new SwipeEvents RecordBuilder
   */
  public static com.kiruthika.pojoavro.v2.SwipeEvents.Builder newBuilder() {
    return new com.kiruthika.pojoavro.v2.SwipeEvents.Builder();
  }

  /**
   * Creates a new SwipeEvents RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new SwipeEvents RecordBuilder
   */
  public static com.kiruthika.pojoavro.v2.SwipeEvents.Builder newBuilder(com.kiruthika.pojoavro.v2.SwipeEvents.Builder other) {
    if (other == null) {
      return new com.kiruthika.pojoavro.v2.SwipeEvents.Builder();
    } else {
      return new com.kiruthika.pojoavro.v2.SwipeEvents.Builder(other);
    }
  }

  /**
   * Creates a new SwipeEvents RecordBuilder by copying an existing SwipeEvents instance.
   * @param other The existing instance to copy.
   * @return A new SwipeEvents RecordBuilder
   */
  public static com.kiruthika.pojoavro.v2.SwipeEvents.Builder newBuilder(com.kiruthika.pojoavro.v2.SwipeEvents other) {
    if (other == null) {
      return new com.kiruthika.pojoavro.v2.SwipeEvents.Builder();
    } else {
      return new com.kiruthika.pojoavro.v2.SwipeEvents.Builder(other);
    }
  }

  /**
   * RecordBuilder for SwipeEvents instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<SwipeEvents>
    implements org.apache.avro.data.RecordBuilder<SwipeEvents> {

    private java.lang.CharSequence dept;
    private int empNo;
    private java.lang.CharSequence eventType;
    private java.lang.CharSequence swipeTime;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.kiruthika.pojoavro.v2.SwipeEvents.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.dept)) {
        this.dept = data().deepCopy(fields()[0].schema(), other.dept);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.empNo)) {
        this.empNo = data().deepCopy(fields()[1].schema(), other.empNo);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.eventType)) {
        this.eventType = data().deepCopy(fields()[2].schema(), other.eventType);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.swipeTime)) {
        this.swipeTime = data().deepCopy(fields()[3].schema(), other.swipeTime);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing SwipeEvents instance
     * @param other The existing instance to copy.
     */
    private Builder(com.kiruthika.pojoavro.v2.SwipeEvents other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.dept)) {
        this.dept = data().deepCopy(fields()[0].schema(), other.dept);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.empNo)) {
        this.empNo = data().deepCopy(fields()[1].schema(), other.empNo);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.eventType)) {
        this.eventType = data().deepCopy(fields()[2].schema(), other.eventType);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.swipeTime)) {
        this.swipeTime = data().deepCopy(fields()[3].schema(), other.swipeTime);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'dept' field.
      * @return The value.
      */
    public java.lang.CharSequence getDept() {
      return dept;
    }


    /**
      * Sets the value of the 'dept' field.
      * @param value The value of 'dept'.
      * @return This builder.
      */
    public com.kiruthika.pojoavro.v2.SwipeEvents.Builder setDept(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.dept = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'dept' field has been set.
      * @return True if the 'dept' field has been set, false otherwise.
      */
    public boolean hasDept() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'dept' field.
      * @return This builder.
      */
    public com.kiruthika.pojoavro.v2.SwipeEvents.Builder clearDept() {
      dept = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'empNo' field.
      * @return The value.
      */
    public int getEmpNo() {
      return empNo;
    }


    /**
      * Sets the value of the 'empNo' field.
      * @param value The value of 'empNo'.
      * @return This builder.
      */
    public com.kiruthika.pojoavro.v2.SwipeEvents.Builder setEmpNo(int value) {
      validate(fields()[1], value);
      this.empNo = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'empNo' field has been set.
      * @return True if the 'empNo' field has been set, false otherwise.
      */
    public boolean hasEmpNo() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'empNo' field.
      * @return This builder.
      */
    public com.kiruthika.pojoavro.v2.SwipeEvents.Builder clearEmpNo() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'eventType' field.
      * @return The value.
      */
    public java.lang.CharSequence getEventType() {
      return eventType;
    }


    /**
      * Sets the value of the 'eventType' field.
      * @param value The value of 'eventType'.
      * @return This builder.
      */
    public com.kiruthika.pojoavro.v2.SwipeEvents.Builder setEventType(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.eventType = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'eventType' field has been set.
      * @return True if the 'eventType' field has been set, false otherwise.
      */
    public boolean hasEventType() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'eventType' field.
      * @return This builder.
      */
    public com.kiruthika.pojoavro.v2.SwipeEvents.Builder clearEventType() {
      eventType = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'swipeTime' field.
      * @return The value.
      */
    public java.lang.CharSequence getSwipeTime() {
      return swipeTime;
    }


    /**
      * Sets the value of the 'swipeTime' field.
      * @param value The value of 'swipeTime'.
      * @return This builder.
      */
    public com.kiruthika.pojoavro.v2.SwipeEvents.Builder setSwipeTime(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.swipeTime = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'swipeTime' field has been set.
      * @return True if the 'swipeTime' field has been set, false otherwise.
      */
    public boolean hasSwipeTime() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'swipeTime' field.
      * @return This builder.
      */
    public com.kiruthika.pojoavro.v2.SwipeEvents.Builder clearSwipeTime() {
      swipeTime = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public SwipeEvents build() {
      try {
        SwipeEvents record = new SwipeEvents();
        record.dept = fieldSetFlags()[0] ? this.dept : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.empNo = fieldSetFlags()[1] ? this.empNo : (java.lang.Integer) defaultValue(fields()[1]);
        record.eventType = fieldSetFlags()[2] ? this.eventType : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.swipeTime = fieldSetFlags()[3] ? this.swipeTime : (java.lang.CharSequence) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<SwipeEvents>
    WRITER$ = (org.apache.avro.io.DatumWriter<SwipeEvents>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<SwipeEvents>
    READER$ = (org.apache.avro.io.DatumReader<SwipeEvents>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    if (this.dept == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.dept);
    }

    out.writeInt(this.empNo);

    if (this.eventType == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.eventType);
    }

    if (this.swipeTime == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.swipeTime);
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      if (in.readIndex() != 1) {
        in.readNull();
        this.dept = null;
      } else {
        this.dept = in.readString(this.dept instanceof Utf8 ? (Utf8)this.dept : null);
      }

      this.empNo = in.readInt();

      if (in.readIndex() != 1) {
        in.readNull();
        this.eventType = null;
      } else {
        this.eventType = in.readString(this.eventType instanceof Utf8 ? (Utf8)this.eventType : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.swipeTime = null;
      } else {
        this.swipeTime = in.readString(this.swipeTime instanceof Utf8 ? (Utf8)this.swipeTime : null);
      }

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          if (in.readIndex() != 1) {
            in.readNull();
            this.dept = null;
          } else {
            this.dept = in.readString(this.dept instanceof Utf8 ? (Utf8)this.dept : null);
          }
          break;

        case 1:
          this.empNo = in.readInt();
          break;

        case 2:
          if (in.readIndex() != 1) {
            in.readNull();
            this.eventType = null;
          } else {
            this.eventType = in.readString(this.eventType instanceof Utf8 ? (Utf8)this.eventType : null);
          }
          break;

        case 3:
          if (in.readIndex() != 1) {
            in.readNull();
            this.swipeTime = null;
          } else {
            this.swipeTime = in.readString(this.swipeTime instanceof Utf8 ? (Utf8)this.swipeTime : null);
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










