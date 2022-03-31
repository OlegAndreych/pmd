/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */


package net.sourceforge.pmd.lang.html.ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.nodes.Element;

import net.sourceforge.pmd.lang.ast.xpath.Attribute;

public class HtmlElement extends AbstractHtmlNode<Element> {

    private final List<Attribute> attributes;

    HtmlElement(Element element) {
        super(element);

        attributes = new ArrayList<>();
        for (org.jsoup.nodes.Attribute att : node.attributes()) {
            attributes.add(new Attribute(this, att.getKey(), att.getValue()));
        }
    }

    @Override
    public Iterator<Attribute> getXPathAttributesIterator() {
        Iterator<Attribute> defaultAttributes = super.getXPathAttributesIterator();
        Iterator<Attribute> elementAttributes = attributes.iterator();

        return new Iterator<Attribute>() {
            @Override
            public boolean hasNext() {
                return defaultAttributes.hasNext() || elementAttributes.hasNext();
            }

            @Override
            public Attribute next() {
                if (defaultAttributes.hasNext()) {
                    return defaultAttributes.next();
                }
                return elementAttributes.next();
            }
        };
    }
}
