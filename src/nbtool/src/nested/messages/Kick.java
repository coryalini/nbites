// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PMotion.proto

package messages;

/**
 * Protobuf type {@code messages.Kick}
 */
public final class Kick extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:messages.Kick)
    KickOrBuilder {
  // Use Kick.newBuilder() to construct.
  private Kick(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
    this.unknownFields = builder.getUnknownFields();
  }
  private Kick(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

  private static final Kick defaultInstance;
  public static Kick getDefaultInstance() {
    return defaultInstance;
  }

  public Kick getDefaultInstanceForType() {
    return defaultInstance;
  }

  private final com.google.protobuf.UnknownFieldSet unknownFields;
  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
      getUnknownFields() {
    return this.unknownFields;
  }
  private Kick(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    initFields();
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownField(input, unknownFields,
                                   extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 16: {
            int rawValue = input.readEnum();
            messages.Kick.KickType value = messages.Kick.KickType.valueOf(rawValue);
            if (value == null) {
              unknownFields.mergeVarintField(2, rawValue);
            } else {
              bitField0_ |= 0x00000001;
              type_ = value;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e.getMessage()).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return messages._File_PMotion.internal_static_messages_Kick_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return messages._File_PMotion.internal_static_messages_Kick_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            messages.Kick.class, messages.Kick.Builder.class);
  }

  public static com.google.protobuf.Parser<Kick> PARSER =
      new com.google.protobuf.AbstractParser<Kick>() {
    public Kick parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Kick(input, extensionRegistry);
    }
  };

  @java.lang.Override
  public com.google.protobuf.Parser<Kick> getParserForType() {
    return PARSER;
  }

  /**
   * Protobuf enum {@code messages.Kick.KickType}
   */
  public enum KickType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>kickForwardLeft = 0;</code>
     */
    kickForwardLeft(0, 0),
    /**
     * <code>kickForwardRight = 1;</code>
     */
    kickForwardRight(1, 1),
    ;

    /**
     * <code>kickForwardLeft = 0;</code>
     */
    public static final int kickForwardLeft_VALUE = 0;
    /**
     * <code>kickForwardRight = 1;</code>
     */
    public static final int kickForwardRight_VALUE = 1;


    public final int getNumber() { return value; }

    public static KickType valueOf(int value) {
      switch (value) {
        case 0: return kickForwardLeft;
        case 1: return kickForwardRight;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<KickType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static com.google.protobuf.Internal.EnumLiteMap<KickType>
        internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<KickType>() {
            public KickType findValueByNumber(int number) {
              return KickType.valueOf(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(index);
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return messages.Kick.getDescriptor().getEnumTypes().get(0);
    }

    private static final KickType[] VALUES = values();

    public static KickType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }

    private final int index;
    private final int value;

    private KickType(int index, int value) {
      this.index = index;
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:messages.Kick.KickType)
  }

  private int bitField0_;
  public static final int TYPE_FIELD_NUMBER = 2;
  private messages.Kick.KickType type_;
  /**
   * <code>optional .messages.Kick.KickType type = 2;</code>
   */
  public boolean hasType() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional .messages.Kick.KickType type = 2;</code>
   */
  public messages.Kick.KickType getType() {
    return type_;
  }

  private void initFields() {
    type_ = messages.Kick.KickType.kickForwardLeft;
  }
  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeEnum(2, type_.getNumber());
    }
    getUnknownFields().writeTo(output);
  }

  private int memoizedSerializedSize = -1;
  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, type_.getNumber());
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSerializedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  protected java.lang.Object writeReplace()
      throws java.io.ObjectStreamException {
    return super.writeReplace();
  }

  public static messages.Kick parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.Kick parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.Kick parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.Kick parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.Kick parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static messages.Kick parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static messages.Kick parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static messages.Kick parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static messages.Kick parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static messages.Kick parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public static Builder newBuilder() { return Builder.create(); }
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder(messages.Kick prototype) {
    return newBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() { return newBuilder(this); }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code messages.Kick}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:messages.Kick)
      messages.KickOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return messages._File_PMotion.internal_static_messages_Kick_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return messages._File_PMotion.internal_static_messages_Kick_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              messages.Kick.class, messages.Kick.Builder.class);
    }

    // Construct using messages.Kick.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
      }
    }
    private static Builder create() {
      return new Builder();
    }

    public Builder clear() {
      super.clear();
      type_ = messages.Kick.KickType.kickForwardLeft;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    public Builder clone() {
      return create().mergeFrom(buildPartial());
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return messages._File_PMotion.internal_static_messages_Kick_descriptor;
    }

    public messages.Kick getDefaultInstanceForType() {
      return messages.Kick.getDefaultInstance();
    }

    public messages.Kick build() {
      messages.Kick result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public messages.Kick buildPartial() {
      messages.Kick result = new messages.Kick(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.type_ = type_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof messages.Kick) {
        return mergeFrom((messages.Kick)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(messages.Kick other) {
      if (other == messages.Kick.getDefaultInstance()) return this;
      if (other.hasType()) {
        setType(other.getType());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      messages.Kick parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (messages.Kick) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private messages.Kick.KickType type_ = messages.Kick.KickType.kickForwardLeft;
    /**
     * <code>optional .messages.Kick.KickType type = 2;</code>
     */
    public boolean hasType() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional .messages.Kick.KickType type = 2;</code>
     */
    public messages.Kick.KickType getType() {
      return type_;
    }
    /**
     * <code>optional .messages.Kick.KickType type = 2;</code>
     */
    public Builder setType(messages.Kick.KickType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      type_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional .messages.Kick.KickType type = 2;</code>
     */
    public Builder clearType() {
      bitField0_ = (bitField0_ & ~0x00000001);
      type_ = messages.Kick.KickType.kickForwardLeft;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:messages.Kick)
  }

  static {
    defaultInstance = new Kick(true);
    defaultInstance.initFields();
  }

  // @@protoc_insertion_point(class_scope:messages.Kick)
}

