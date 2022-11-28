/*
 *  DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 *  Copyright (c) [2022] Payara Foundation and/or its affiliates. All rights reserved.
 * 
 *  The contents of this file are subject to the terms of either the GNU
 *  General Public License Version 2 only ("GPL") or the Common Development
 *  and Distribution License("CDDL") (collectively, the "License").  You
 *  may not use this file except in compliance with the License.  You can
 *  obtain a copy of the License at
 *  https://github.com/payara/Payara/blob/master/LICENSE.txt
 *  See the License for the specific
 *  language governing permissions and limitations under the License.
 * 
 *  When distributing the software, include this License Header Notice in each
 *  file and include the License file at glassfish/legal/LICENSE.txt.
 * 
 *  GPL Classpath Exception:
 *  The Payara Foundation designates this particular file as subject to the "Classpath"
 *  exception as provided by the Payara Foundation in the GPL Version 2 section of the License
 *  file that accompanied this code.
 * 
 *  Modifications:
 *  If applicable, add the following below the License Header, with the fields
 *  enclosed by brackets [] replaced by your own identifying information:
 *  "Portions Copyright [year] [name of copyright owner]"
 * 
 *  Contributor(s):
 *  If you wish your version of this file to be governed by only the CDDL or
 *  only the GPL Version 2, indicate your decision by adding "[Contributor]
 *  elects to include this software in this distribution under the [CDDL or GPL
 *  Version 2] license."  If you don't indicate a single choice of license, a
 *  recipient has the option to distribute your version of this file under
 *  either the CDDL, the GPL Version 2 or to extend the choice of license to
 *  its licensees as provided above.  However, if you add GPL Version 2 code
 *  and therefore, elected the GPL Version 2 license, then the option applies
 *  only if the new code is made subject to such option by the copyright
 *  holder.
 */
package org.glassfish.external.statistics.impl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.glassfish.external.statistics.ListStatistic;
import org.glassfish.external.statistics.Statistic;

/**
 * A list of other {@link org.glassfish.external.statistics.Statistic Statistic}s.
 * <p>
 * This differs from {@link org.glassfish.external.statistics.Stats} in that this has its own
 * name and given unit and description, which {@link org.glassfish.external.statistics.Stats}
 * does not have.
 * 
 * @see StatsImpl
 * @since 3.2.1-b002.payara-p1
 * @author jonathan coustick
 */
public class ListStatisticImpl extends StatisticImpl implements ListStatistic, List<StatisticImpl> {

    private final List<StatisticImpl> statList;
    
    public ListStatisticImpl(String name, String unit, String desc) {
        super(name, unit, desc);
        statList = new ArrayList<StatisticImpl>();
    }

    @Override
    public synchronized Map getStaticAsMap(){
        super.getStaticAsMap();
        List<Map> mappedItems = new ArrayList<Map>();
        for (StatisticImpl item : statList) {
            mappedItems.add(item.getStaticAsMap());
        }
        statMap.put("items", mappedItems);
        return statMap;
    }
    
    @Override
    public String toString(){
        String result = super.toString();
        result += "Items: " + NEWLINE;
        for (StatisticImpl stat: statList){
            result += "\t" + stat.toString() + NEWLINE;
        }
        return result;
    }
    
    @Override
    public List<StatisticImpl> getCurrentStats() {
        return statList;
    }

    public int size() {
        return statList.size();
    }

    public boolean isEmpty() {
        return statList.isEmpty();
    }

    public boolean contains(StatisticImpl o) {
        return statList.contains(o);
    }

    public Iterator iterator() {
        return statList.iterator();
    }

    public StatisticImpl[] toArray() {
        return statList.toArray(new StatisticImpl[0]);
    }

    public boolean add(StatisticImpl e) {
        return statList.add(e);
    }

    public boolean remove(Object o) {
        return statList.remove(o);
    }

    public boolean containsAll(Collection c) {
        return statList.containsAll(c);
    }

    public boolean addAll(Collection c) {
        return statList.addAll(c);
    }

    public boolean addAll(int index, Collection c) {
        return statList.addAll(index, c);
    }

    public boolean removeAll(Collection c) {
        return statList.removeAll(c);
    }

    public boolean retainAll(Collection c) {
        return statList.retainAll(c);
    }

    public void clear() {
        statList.clear();
    }

    public StatisticImpl get(int index) {
        return statList.get(index);
    }

    public StatisticImpl set(int index, StatisticImpl element) {
        return statList.set(index, element);
    }

    public void add(int index, StatisticImpl element) {
        statList.add(index, element);
    }

    public StatisticImpl remove(int index) {
        return statList.remove(index);
    }

    public int indexOf(Object o) {
        return statList.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return statList.lastIndexOf(o);
    }

    public ListIterator listIterator() {
        return statList.listIterator();
    }

    public ListIterator listIterator(int index) {
        return statList.listIterator(index);
    }

    public List subList(int fromIndex, int toIndex) {
        return statList.subList(fromIndex, toIndex);
    }

    public boolean contains(Object o) {
        return statList.contains(o);
    }

    public <T> T[] toArray(T[] a) {
        return statList.toArray(a);
    }
    
}
