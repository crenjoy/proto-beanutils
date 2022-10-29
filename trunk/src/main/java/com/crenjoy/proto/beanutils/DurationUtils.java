package com.crenjoy.proto.beanutils;

/**
 * Time Duration <-> Proto Duration.
 *
 * @author CGD
 *
 */
public class DurationUtils {

  /**
   * Proto Duration -> Time Duration . Proto Duration (seconds,nanos) Symbolic
   * consistency. Time Duration (seconds,nanos) nanos no Symbolic .
   */
  public static java.time.Duration toTime(com.google.protobuf.Duration src) {
    if (src.getSeconds() < 0L && src.getNanos() < 0) {
      return java.time.Duration.ofSeconds(src.getSeconds() - 1, 1000_000_000L + src.getNanos());
    } else {
      return java.time.Duration.ofSeconds(src.getSeconds(), src.getNanos());
    }
  }

  /**
   * Time Duration -> Proto Duration . Proto Duration (seconds,nanos) Symbolic
   * consistency. Time Duration (seconds,nanos) nanos no Symbolic .
   */
  public static com.google.protobuf.Duration toProto(java.time.Duration src) {
    if (src.getSeconds() < 0L && src.getNano() > 0) {
      return com.google.protobuf.Duration.newBuilder().setSeconds(src.getSeconds() + 1)
          .setNanos(Long.valueOf(src.getNano() - 1000_000_000L).intValue()).build();
    } else {
      return com.google.protobuf.Duration.newBuilder().setSeconds(src.getSeconds())
          .setNanos(src.getNano()).build();
    }
  }

}
