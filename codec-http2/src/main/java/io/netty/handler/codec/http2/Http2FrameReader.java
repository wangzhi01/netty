/*
 * Copyright 2014 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License, version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import java.io.Closeable;

/**
 * Reads HTTP/2 frames from an input {@link ByteBuf} and notifies the specified
 * {@link Http2FrameObserver} when frames are complete.
 */
public interface Http2FrameReader extends Closeable {

    /**
     * Attempts to read the next frame from the input buffer. If enough data is available to fully
     * read the frame, notifies the observer of the read frame.
     */
    void readFrame(ByteBufAllocator alloc, ByteBuf input, Http2FrameObserver observer)
            throws Http2Exception;

    /**
     * Sets the maximum size of the HPACK header table used for decoding HTTP/2 headers.
     */
    void maxHeaderTableSize(int max);

    /**
     * Gets the maximum size of the HPACK header table used for decoding HTTP/2 headers.
     */
    int maxHeaderTableSize();

    /**
     * Closes this reader and frees any allocated resources.
     */
    @Override
    void close();
}
