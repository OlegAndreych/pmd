/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */


package net.sourceforge.pmd.lang.html.ast;

import org.jsoup.nodes.DocumentType;

public final class HtmlDocumentType extends AbstractHtmlNode<DocumentType> {

    HtmlDocumentType(DocumentType node) {
        super(node);
    }

    public String getName() {
        return node.name();
    }

    public String getPublicId() {
        return node.publicId();
    }

    public String getSystemId() {
        return node.systemId();
    }
}
