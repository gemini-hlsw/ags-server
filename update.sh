#!/bin/bash

set -e

if [ -z $1 ]; then
  echo "🔥 Usage: `basename $0` <path to itc distribution bundle directory>"
  exit 1
fi

if [ -d $1 ]; then
  BUNDLE=$(readlink -f "$1")
  LIB="$(dirname "$(readlink -f "$0")")/lib"
  mkdir -p "$LIB"
  echo "🔸 Reading from $BUNDLE"
  echo "🔸 Writing to   $LIB"
else
  echo "🔸 Directory not found: $1"
  exit 1
fi

echo "🔸 Removing old library bundles."
touch "$LIB"/dummy.jar
rm "$LIB"/*.jar

echo "🔸 Copying bundles."
cp "$BUNDLE"/edu-gemini-ags-servlet_2.11*.jar "$LIB"
cp "$BUNDLE"/edu-gemini-ags_2.11*.jar "$LIB"
cp "$BUNDLE"/edu-gemini-catalog_2.11*.jar "$LIB"
cp "$BUNDLE"/argonaut_2.11*.jar "$LIB"
# cp "$BUNDLE"/edu-gemini-itc-shared_2.11*.jar "$LIB"
# cp "$BUNDLE"/edu-gemini-itc-web_2.11*.jar "$LIB"
# cp "$BUNDLE"/edu-gemini-itc_2.11*.jar "$LIB"
cp "$BUNDLE"/edu-gemini-json_2.11*.jar "$LIB"
cp "$BUNDLE"/edu-gemini-pot_2.11*.jar "$LIB"
# cp "$BUNDLE"/edu-gemini-shared-skyobject_2.11*.jar "$LIB"
cp "$BUNDLE"/edu-gemini-shared-util_2.11*.jar "$LIB"
cp "$BUNDLE"/edu-gemini-spmodel-core_2.11*.jar "$LIB"
cp "$BUNDLE"/edu-gemini-spmodel-pio_2.11*.jar "$LIB"
cp "$BUNDLE"/edu-gemini-util-skycalc_2.11*.jar "$LIB"
cp "$BUNDLE"/edu-gemini-model-p1_2.11*.jar "$LIB"
# cp "$BUNDLE"/org-jfree_*.jar "$LIB"
cp "$BUNDLE"/scalaz-core_2.11*.jar "$LIB"
cp "$BUNDLE"/scalaz-concurrent_2.11*.jar "$LIB"
cp "$BUNDLE"/scala-xml_2.11*.jar "$LIB"
cp "$BUNDLE"/squants_2.11*.jar "$LIB"
cp "$BUNDLE"/org-dom4j*.jar "$LIB"
cp "$BUNDLE"/scala-parser-combinators_2.11*.jar "$LIB"
cp "$BUNDLE"/org.apache.httpcomponents.httpcore*.jar "$LIB"
cp "$BUNDLE"/org.apache.httpcomponents.httpclient*.jar "$LIB"
cp "$BUNDLE"/org-apache-commons-logging*.jar "$LIB"
#
