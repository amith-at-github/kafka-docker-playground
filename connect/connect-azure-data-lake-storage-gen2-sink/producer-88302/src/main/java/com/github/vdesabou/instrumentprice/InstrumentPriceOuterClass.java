// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: InstrumentPrice.proto

package com.github.vdesabou.instrumentprice;

public final class InstrumentPriceOuterClass {
  private InstrumentPriceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface InstrumentPriceOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.github.vdesabou.instrumentprice.InstrumentPrice)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 price = 123;</code>
     * @return The price.
     */
    long getPrice();
  }
  /**
   * Protobuf type {@code com.github.vdesabou.instrumentprice.InstrumentPrice}
   */
  public  static final class InstrumentPrice extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.github.vdesabou.instrumentprice.InstrumentPrice)
      InstrumentPriceOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use InstrumentPrice.newBuilder() to construct.
    private InstrumentPrice(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private InstrumentPrice() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new InstrumentPrice();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private InstrumentPrice(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
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
            case 984: {

              price_ = input.readInt64();
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.internal_static_com_github_vdesabou_instrumentprice_InstrumentPrice_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.internal_static_com_github_vdesabou_instrumentprice_InstrumentPrice_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice.class, com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice.Builder.class);
    }

    public static final int PRICE_FIELD_NUMBER = 123;
    private long price_;
    /**
     * <code>int64 price = 123;</code>
     * @return The price.
     */
    public long getPrice() {
      return price_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (price_ != 0L) {
        output.writeInt64(123, price_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (price_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(123, price_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice)) {
        return super.equals(obj);
      }
      com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice other = (com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice) obj;

      if (getPrice()
          != other.getPrice()) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + PRICE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getPrice());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.github.vdesabou.instrumentprice.InstrumentPrice}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.github.vdesabou.instrumentprice.InstrumentPrice)
        com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPriceOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.internal_static_com_github_vdesabou_instrumentprice_InstrumentPrice_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.internal_static_com_github_vdesabou_instrumentprice_InstrumentPrice_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice.class, com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice.Builder.class);
      }

      // Construct using com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        price_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.internal_static_com_github_vdesabou_instrumentprice_InstrumentPrice_descriptor;
      }

      @java.lang.Override
      public com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice getDefaultInstanceForType() {
        return com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice.getDefaultInstance();
      }

      @java.lang.Override
      public com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice build() {
        com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice buildPartial() {
        com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice result = new com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice(this);
        result.price_ = price_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice) {
          return mergeFrom((com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice other) {
        if (other == com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice.getDefaultInstance()) return this;
        if (other.getPrice() != 0L) {
          setPrice(other.getPrice());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long price_ ;
      /**
       * <code>int64 price = 123;</code>
       * @return The price.
       */
      public long getPrice() {
        return price_;
      }
      /**
       * <code>int64 price = 123;</code>
       * @param value The price to set.
       * @return This builder for chaining.
       */
      public Builder setPrice(long value) {
        
        price_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 price = 123;</code>
       * @return This builder for chaining.
       */
      public Builder clearPrice() {
        
        price_ = 0L;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:com.github.vdesabou.instrumentprice.InstrumentPrice)
    }

    // @@protoc_insertion_point(class_scope:com.github.vdesabou.instrumentprice.InstrumentPrice)
    private static final com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice();
    }

    public static com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<InstrumentPrice>
        PARSER = new com.google.protobuf.AbstractParser<InstrumentPrice>() {
      @java.lang.Override
      public InstrumentPrice parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new InstrumentPrice(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<InstrumentPrice> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<InstrumentPrice> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.github.vdesabou.instrumentprice.InstrumentPriceOuterClass.InstrumentPrice getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_github_vdesabou_instrumentprice_InstrumentPrice_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_github_vdesabou_instrumentprice_InstrumentPrice_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025InstrumentPrice.proto\022#com.github.vdes" +
      "abou.instrumentprice\" \n\017InstrumentPrice\022" +
      "\r\n\005price\030{ \001(\003b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_github_vdesabou_instrumentprice_InstrumentPrice_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_github_vdesabou_instrumentprice_InstrumentPrice_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_github_vdesabou_instrumentprice_InstrumentPrice_descriptor,
        new java.lang.String[] { "Price", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
