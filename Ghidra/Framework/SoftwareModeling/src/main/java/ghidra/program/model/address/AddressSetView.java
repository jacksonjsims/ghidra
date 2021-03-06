/* ###
 * IP: GHIDRA
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
/* Generated by Together */

package ghidra.program.model.address;

import java.util.Iterator;

/**
 * Defines a read-only interface for an address set.
 */
public interface AddressSetView extends Iterable<AddressRange> {
	/**
	 * Test if the address is contained within this set.
	 * <P>
	 * @param addr address to test.
	 * @return true if addr exists in the set, false otherwise.
	 */
	public boolean contains(Address addr);

	/**
	 * Test if the given address range is contained in this set.
	 * <P>
	 * @param start the first address in the range.
	 * @param end the last address in the range.
	 * @return true if entire range is contained within the set,
	 *         false otherwise.
	 */
	public boolean contains(Address start, Address end);

	/**
	 * Test if the given address set is a subset of this set.
	 * <P>
	 * @param rangeSet the set to test.
	 * @return true if the entire set is contained within this set,
	 *         false otherwise.
	 */
	public boolean contains(AddressSetView rangeSet);

	/**
	 * Returns true if this set is empty.
	 */
	public boolean isEmpty();

	/**
	 * Return the minimum address for this set. Returns null if the set is empty.
	 */
	public Address getMinAddress();

	/**
	 * Return the maximum address for this set. Returns null if the set is empty.
	 */
	public Address getMaxAddress();

	/**
	 * Return the number of address ranges in this set.
	 */
	public int getNumAddressRanges();

	/**
	 * Returns an iterator over the address ranges in this address set.
	 */
	public AddressRangeIterator getAddressRanges();

	/**
	 * Returns an iterator over the ranges in the specified order
	 * @param forward the ranges are returned from lowest to highest, otherwise from
	 * highest to lowest
	 * @return an iterator over all the addresse ranges in the set.
	 */
	public AddressRangeIterator getAddressRanges(boolean forward);

	/**
	 * Returns an iterator of address ranges starting with the range that contains the given address.
	 * If there is no range containing the start address, then the the first range will be
	 * the next range greater than the start address if going forward, otherwise the range less than
	 * the start address
	 * @param start the address the the first range should contain.
	 * @param forward true iterators forward, false backwards
	 * @return the AddressRange iterator
	 */
	public AddressRangeIterator getAddressRanges(Address start, boolean forward);

	/**
	 * Returns an iterator over the address ranges in this address set.
	 */
	@Override
	public Iterator<AddressRange> iterator();

	/**
	 * Returns an iterator over the ranges in the specified order
	 * @param forward the ranges are returned from lowest to highest, otherwise from
	 * highest to lowest
	 * @return an iterator over all the addresse ranges in the set.
	 */
	public Iterator<AddressRange> iterator(boolean forward);

	/**
	 * Returns an iterator of address ranges starting with the range that contains the given address.
	 * If there is no range containing the start address, then the the first range will be
	 * the next range greater than the start address if going forward, otherwise the range less than
	 * the start address
	 * @param start the address the the first range should contain.
	 * @param forward true iterators forward, false backwards
	 * @return the AddressRange iterator
	 */
	public Iterator<AddressRange> iterator(Address start, boolean forward);

	/**
	 * Returns the number of addresses in this set.
	 */
	public long getNumAddresses();

	/**
	 * Returns an iterator over all addresses in this set.
	 * @param forward if true the address are return in increasing order, otherwise in
	 * decreasing order.
	 */
	public AddressIterator getAddresses(boolean forward);

	/**
	 * Returns an iterator over the addresses in this address set
	 * starting at the start address
	 * @param start address to start iterating at in the address set
	 * @param forward if true address are return from lowest to highest, else from highest to lowest
	 */
	public AddressIterator getAddresses(Address start, boolean forward);

	/**
	 * Determine if this address set intersects with the specified address set.
	 *
	 * @param addrSet address set to check intersection with.
	 */
	public boolean intersects(AddressSetView addrSet);

	/**
	 * Determine if the start and end range
	 * intersects with the specified address set.
	 * @param start start of range
	 * @param end end of range
	 * @return true if the given range intersects this address set.
	 */
	public boolean intersects(Address start, Address end);

	/**
	 * Computes the intersection of this address set with the given address set.
	 * This method does not modify this address set.
	 * @param view the address set to intersect with.
	 * @return AddressSet a new address set that contains all addresses that are
	 * contained in both this set and the given set.
	 */
	public AddressSet intersect(AddressSetView view);

	/**
	 * Computes the intersection of this address set with the given address range.
	 * This method does not modify this address set.
	 * @param start start of range
	 * @param end end of range
	 * @return AddressSet a new address set that contains all addresses that are
	 * contained in both this set and the given range.
	 */
	public AddressSet intersectRange(Address start, Address end);

	/**
	 * Computes the union of this address set with the given address set.  This
	 * method does not change this address set.
	 * @param addrSet The address set to be unioned with this address set.
	 * @return AddressSet A new address set which contains all the addresses
	 * from both this set and the given set.
	 */
	public AddressSet union(AddressSetView addrSet);

	/**
	 * Computes the difference of this address set with the given address set
	 * (this - set).  Note that this is not the same as (set - this).  This
	 * method does not change this address set.
	 * @param addrSet the set to subtract from this set.
	 * @return AddressSet a new address set which contains all the addresses
	 * that are in this set, but not in the given set.
	 */
	public AddressSet subtract(AddressSetView addrSet);

	/**
	 * Computes the exclusive-or of this address set with the given set. This
	 * method does not modify this address set.
	 * @param addrSet
	 * @return AddressSet a new address set containing all addresses that are in
	 * either this set or the given set, but not in both sets
	 */
	public AddressSet xor(AddressSetView addrSet);

	/**
	 * Returns true if the given address set contains the same set of addresses
	 * as this set.
	 * @param view the address set to compare.
	 * @return true if the given set contains the same addresses as this set.
	 */
	public boolean hasSameAddresses(AddressSetView view);

	/**
	 * Returns the first range in this set or null if the set is empty;
	 * @return the first range in this set or null if the set is empty;
	 */
	public AddressRange getFirstRange();

	/**
	 * Returns the last range in this set or null if the set is empty;
	 * @return the last range in this set or null if the set is empty;
	 */
	public AddressRange getLastRange();

	/**
	 * Returns the range that contains the given address
	 * @param address the address for which to find a range.
	 * @return the range that contains the given address.
	 */
	public AddressRange getRangeContaining(Address address);

	/**
	 * Finds the first address in this collection that is also in the given addressSet.
	 * @param set the addressSet to search for the first (lowest) common address.
	 * @return the first address that is contained in this set and the given set.
	 */
	public Address findFirstAddressInCommon(AddressSetView set);
}
