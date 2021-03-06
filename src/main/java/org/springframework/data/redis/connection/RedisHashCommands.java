/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.redis.connection;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;

/**
 * Hash-specific commands supported by Redis.
 * 
 * @author Costin Leau
 * @author Christoph Strobl
 */
public interface RedisHashCommands {

	/**
	 * Set the {@code value} of a hash {@code field}.
	 * 
	 * @see http://redis.io/commands/hset
	 * @param key
	 * @param field
	 * @param value
	 * @return
	 */
	Boolean hSet(byte[] key, byte[] field, byte[] value);

	/**
	 * Set the {@code value} of a hash {@code field} only if {@code field} does not exist.
	 * 
	 * @see http://redis.io/commands/hsetnx
	 * @param key
	 * @param field
	 * @param value
	 * @return
	 */
	Boolean hSetNX(byte[] key, byte[] field, byte[] value);

	/**
	 * Get value for given {@code field} from hash at {@code key}.
	 * 
	 * @see http://redis.io/commands/hget
	 * @param key
	 * @param field
	 * @return
	 */
	byte[] hGet(byte[] key, byte[] field);

	/**
	 * Get values for given {@code fields} from hash at {@code key}.
	 * 
	 * @see http://redis.io/commands/hmget
	 * @param key
	 * @param fields
	 * @return
	 */
	List<byte[]> hMGet(byte[] key, byte[]... fields);

	/**
	 * Set multiple hash fields to multiple values using data provided in {@code hashes}
	 * 
	 * @see http://redis.io/commands/hmset
	 * @param key
	 * @param hashes
	 */
	void hMSet(byte[] key, Map<byte[], byte[]> hashes);

	/**
	 * Increment {@code value} of a hash {@code field} by the given {@code delta}.
	 * 
	 * @see http://redis.io/commands/hincrby
	 * @param key
	 * @param field
	 * @param delta
	 * @return
	 */
	Long hIncrBy(byte[] key, byte[] field, long delta);

	/**
	 * Increment {@code value} of a hash {@code field} by the given {@code delta}.
	 * 
	 * @see http://redis.io/commands/hincrbyfloat
	 * @param key
	 * @param field
	 * @param delta
	 * @return
	 */
	Double hIncrBy(byte[] key, byte[] field, double delta);

	/**
	 * Determine if given hash {@code field} exists.
	 * 
	 * @see http://redis.io/commands/hexits
	 * @param key
	 * @param field
	 * @return
	 */
	Boolean hExists(byte[] key, byte[] field);

	/**
	 * Delete given hash {@code fields}.
	 * 
	 * @see http://redis.io/commands/hdel
	 * @param key
	 * @param fields
	 * @return
	 */
	Long hDel(byte[] key, byte[]... fields);

	/**
	 * Get size of hash at {@code key}.
	 * 
	 * @see http://redis.io/commands/hlen
	 * @param key
	 * @return
	 */
	Long hLen(byte[] key);

	/**
	 * Get key set (fields) of hash at {@code key}.
	 * 
	 * @see http://redis.io/commands/h?
	 * @param key
	 * @return
	 */
	Set<byte[]> hKeys(byte[] key);

	/**
	 * Get entry set (values) of hash at {@code field}.
	 * 
	 * @see http://redis.io/commands/hvals
	 * @param key
	 * @return
	 */
	List<byte[]> hVals(byte[] key);

	/**
	 * Get entire hash stored at {@code key}.
	 * 
	 * @see http://redis.io/commands/hgetall
	 * @param key
	 * @return
	 */
	Map<byte[], byte[]> hGetAll(byte[] key);

	/**
	 * Use a {@link Cursor} to iterate over entries in hash at {@code key}.
	 * 
	 * @since 1.4
	 * @see http://redis.io/commands/scan
	 * @param key
	 * @param options
	 * @return
	 */
	Cursor<Map.Entry<byte[], byte[]>> hScan(byte[] key, ScanOptions options);
}
