public class MBTIPersonalityInformation{

  private String sources = """
\033[1m\033[4mLearn more:\033[0m
\033[1m1. Myers-Briggs Type Indicator (MBTI):\033[0m The official MBTI website provides comprehensive insights into the 16 personality types, their traits and applications. (\033[4mhttps://www.myersbriggs.org/\033[0m)
\033[1m2. 16Personalities:\033[0m This website offers in-depth profiles, articles and resources on the 16 personality types, including strengths, weaknesses and relationships. (\033[4mhttps://www.16personalities.com/\033[0m)
""";

  private String[] personalityTypeSummary = {"""
\033[1m\033[31mISTJ (Sentinels: Logistician)
Introverted (I), Sensing (S), Thinking (T), Judging (J)\033[0m

\033[1m\033[4mOverview\033[0m
ISTJs are dependable, practical and responsible individuals who value structure, tradition and logical analysis. They're reserved, yet resolute, with a rational approach to life, emphasizing duty, loyalty and organization.

\033[1m\033[4mKey Traits\033[0m
1. Practical and detail-oriented.
2. Logical analysis guides decision-making.
3. Organized, systematic approach.
4. Responsible and loyal.

\033[1m\033[4mComprehensive Profile\033[0m
ISTJs shine with reliability, dependability and analytical problem-solving skills, making them effective planners. They thrive in structured environments like finance, administration and military. However, their conservative nature may resist change, and perfectionism can lead to criticism. Emotional reserve can hinder personal connections. To grow, ISTJs should balance logic with emotional intelligence, cultivate flexibility and nurture open communication, fostering deeper relationships and adaptability.

\033[1m\033[4mMBTI Keywords\033[0m
1. Introverted (I): Private, quiet, contemplative, intimate, reflective, contained.
2. Sensing (S): Concrete, realistic, present, practical, experiential, traditional.
3. Thinking (T): Logical, reasonable, questioning, objective, critical, tough-minded.
4. Judging (J): Systematic, planful, early starting, closure, scheduled, methodical.
""","""
\033[1m\033[31mISFJ (Sentinels: Defender)
Introverted (I), Sensing (S), Feeling (F), Judging (J)\033[0m

\033[1m\033[4mOverview\033[0m
ISFJs are dedicated protectors, warm and unassuming, with a strong sense of responsibility. They're efficient, practical and caring, valuing harmony and order in daily life.

\033[1m\033[4mKey Traits\033[0m
1. Loyal and conscientious, ensuring obligations are met.
2. Meticulous and organized, with excellent analytical skills.
3. Sensitive, empathetic and supportive, prioritizing others' feelings.
4. Dependable, practical and hardworking.

\033[1m\033[4mComprehensive Profile\033[0m
ISFJs are steadfast, responsible individuals who prioritize harmony and support. Strengths include reliability, attention to detail and a nurturing nature. They excel in roles requiring organization, empathy and practicality (e.g., teaching, healthcare, administration). Growth areas: assertiveness, emotional expression and adapting to change. ISFJs should balance humility with self-promotion and develop flexibility.

\033[1m\033[4mMBTI Keywords\033[0m
1. Introverted (I): Private, quiet, contemplative, intimate, reflective.
2. Sensing (S): Concrete, realistic, present, practical, experiential.
3. Feeling (F): Empathetic, compassionate, accommodating, subjective.
4. Judging (J): Systematic, planful, decisive, scheduled, methodical.
""","""
\033[1m\033[32mINFJ (Diplomats: Advocate)
Introverted (I), Intuitive (N), Feeling (F), Judging (J)\033[0m

\033[1m\033[4mOverview\033[0m
INFJs are visionary idealists, driven by imagination, integrity and compassion. They seek meaning, connection and fulfilment through serving others and making a positive impact.

\033[1m\033[4mKey Traits\033[0m
1. Idealistic, principled and guided by inner values.
2. Empathetic, insightful and understanding of human motivations.
3. Conscientious, organized and decisive in pursuing their vision.
4. Passionate, creative and serious about making a difference.

\033[1m\033[4mComprehensive Profile\033[0m
INFJs are inspiring, tireless advocates for good. Strengths: strategic thinking, emotional intelligence and perseverance. They excel in roles requiring vision, empathy and integrity (e.g., counselling, education, social justice). Growth areas: assertiveness, self-care and flexibility. INFJs should balance idealism with pragmatism and nurture their physical and emotional well-being.

\033[1m\033[4mMBTI Keywords\033[0m
1. Introverted (I): Private, quiet, contemplative, intimate, reflective.
2. Intuitive (N): Imaginative, future-focused, conceptual, innovative.
3. Feeling (F): Empathetic, compassionate, accommodating, values-driven.
4. Judging (J): Systematic, planful, decisive, scheduled, methodical.
""","""
\033[1m\033[34mINTJ (Analysts: Architect)
Introverted (I), Intuitive (N), Thinking (T), Judging (J)\033[0m

\033[1m\033[4mOverview\033[0m
INTJs are imaginative, strategic thinkers, driven by intellectual curiosity and a desire for mastery. The perfect life's details through creativity, rationality and innovative problem-solving.

\033[1m\033[4mKey Traits\033[0m
1. Intellectually curious, seeking knowledge and self-improvement.
2. Innovative, strategic thinkers with a long-term vision.
3. Logical, analytical and critical in decision-making.
4. Independent, determined and driven to achieve excellence.

\033[1m\033[4mComprehensive Profile\033[0m
INTJs are visionary architects of ideas and systems. Strengths: intellectual agility, strategic thinking and independence. They excel in roles requiring innovation, analysis and leadership (e.g., science, technology, entrepreneurship). Growth areas: emotional intelligence, interpersonal connection and flexibility. INTJs should balance logic with empathy and nurture collaborative relationships.

\033[1m\033[4mMBTI Keywords\033[0m
1. Introverted (I): Private, quiet, contemplative, intimate, reflective.
2. Intuitive (N): Imaginative, future-focused, conceptual, innovative.
3. Thinking (T): Logical, reasonable, questioning, objective.
4. Judging (J): Systematic, planful, decisive, scheduled, methodical.
""","""
\033[1m\033[33mISTP (Explorers: Virtuoso)
Introverted (I), Sensing (S), Thinking (T), Prospecting (P)\033[0m

\033[1m\033[4mOverview\033[0m
ISTPs are resourceful, practical and innovative experimenters, excelling with hands-on problem-solving. They're adaptable, independent and analytical, thriving in dynamic environments.

\033[1m\033[4mKey Traits\033[0m
1. Logical and analytical, seeking efficient solutions.
2. Practical, adaptable and effective troubleshooter.
3. Curious, with a love for hands-on exploration.
4. Independent, valuing flexibility and autonomy.

\033[1m\033[4mComprehensive Profile\033[0m
ISTPs are versatile virtuosos, mastering diverse skills. Strengths: resourcefulness, analytical thinking and adaptability. They excel in roles requiring hands-on expertise, problem-solving and independence (e.g., engineering, technology, emergency response). Growth areas: emotional expression, interpersonal connection and planning. ISTPs should balance flexibility with commitment and nurture collaborative relationships.

\033[1m\033[4mMBTI Keywords\033[0m
1. Introverted (I): Private, quiet, contemplative, intimate, reflective.
2. Sensing (S): Concrete, realistic, present, practical, experiential.
3. Thinking (T): Logical, reasonable, questioning, objective.
4. Prospecting (P): Flexible, adaptable, spontaneous, open-ended.
""","""
\033[1m\033[33mISFP (Explorers: Adventurer)
Introverted (I), Sensing (S), Feeling (F), Prospecting (P)\033[0m

\033[1m\033[4mOverview\033[0m
ISFPs are charming, flexible and spontaneous individuals, embracing life's experiences with warmth and curiosity. They find joy in self-expression, and exploring the present moment.

\033[1m\033[4mKey Traits\033[0m
1. Gentle, compassionate and kind, valuing harmony.
2. Adaptable, spontaneous and open to new experiences.
3. Loyal to their values, loved ones and personal freedom.
4. Aesthetic, appreciating beauty in life's details.

\033[1m\033[4mComprehensive Profile\033[0m
ISFPs are creative adventurers, living life vibrantly. Strengths: adaptability, empathy and authenticity. They thrive in artistic, social and humanitarian roles (e.g., design, counselling, environmental work). Growth areas: assertiveness, planning and emotional resilience. ISFPs should balance spontaneity with commitment and nurture self-expression.

\033[1m\033[4mMBTI Keywords\033[0m
1. Introverted (I): Private, quiet, contemplative, intimate, reflective.
2. Sensing (S): Concrete, realistic, present, practical, experiential.
3. Feeling (F): Empathetic, compassionate, accommodating, values-driven.
4. Prospecting (P): Flexible, adaptable, spontaneous, open-ended.
""","""
\033[1m\033[32mINFP (Diplomats: Mediator)
Introverted (I), Intuitive (N), Feeling (F), Prospecting (P)\033[0m

\033[1m\033[4mOverview\033[0m
INFPs are imaginative, empathetic and altruistic individuals, driven by idealism and a passion for helping others. They value authenticity, creativity and meaningful relationships.

\033[1m\033[4mKey Traits\033[0m
1. Idealistic, with strong loyalty to personal values.
2. Empathetic, compassionate and deeply understanding.
3. Creative, imaginative and inspired by possibilities.
4. Adaptable, flexible and accepting, unless values are compromised.

\033[1m\033[4mComprehensive Profile\033[0m
INFPs are poetic mediators, fostering harmony. Strengths: emotional intelligence, creativity and authenticity. They excel in roles requiring empathy, imagination and advocacy (e.g., counselling, arts, and social justice). Growth areas: assertiveness, resilience and practicality. INFPs should balance idealism with realism and nurture self-care.

\033[1m\033[4mMBTI Keywords\033[0m
1. Introverted (I): Private, quiet, contemplative, intimate, reflective.
2. Intuitive (N): Imaginative, future-focused, conceptual, innovative.
3. Feeling (F): Empathetic, compassionate, accommodating, values-driven.
4. Prospecting (P): Flexible, adaptable, spontaneous, open-ended.
""","""
\033[1m\033[34mINTP (Analysts: Logician)
Introverted (I), Intuitive (N), Thinking (T), Prospecting (P)\033[0m

\033[1m\033[4mOverview\033[0m
INTPs are visionary thinkers, driven by intellectual curiosity and a passion for logical exploration. They excel at analyzing complex ideas, inventing innovative solutions and seeking theoretical understanding. With a detached, objective approach, INTPs thrive in environments that encourage independence, creativity and conceptual thinking. Their ingenious minds constantly question established norms, fostering groundbreaking discoveries.

\033[1m\033[4mKey Traits\033[0m
1. Logically driven, seeking explanations for life's complexities.
2. Theoretical and conceptual, focusing on ideas over social interactions.
3. Analytical, objective and detached in decision-making.
4. Intellectually curious, adaptable and independent.

\033[1m\033[4mComprehensive Profile\033[0m
INTPs are visionary logicians, excelling in theoretical exploration. Strengths: intellectual agility, creativity and critical thinking. They shine in scientific, philosophical and strategic roles (e.g., research, engineering, consulting). Growth areas: interpersonal connection, emotional intelligence and practical application. INTPs should balance analysis with action and nurture collaborative relationships.

\033[1m\033[4mMBTI Keywords\033[0m
1. Introverted (I): Private, quiet, contemplative, intimate, reflective.
2. Intuitive (N): Imaginative, future-focused, conceptual, innovative.
3. Thinking (T): Logical, reasonable, questioning, objective.
4. Prospecting (P): Flexible, adaptable, spontaneous, open-ended.
""","""
\033[1m\033[33mESTP (Explorers: Entrepreneur)
Extraverted (E), Sensing (S), Thinking (T), Prospecting (P)\033[0m

\033[1m\033[4mOverview\033[0m
ESTPs are dynamic, results-driven entrepreneurs, who thrive on action, spontaneity and social interaction. They excel at navigating immediate challenges, seeking excitement and tangible rewards. With pragmatic adaptability, they efficiently resolve problems, prioritizing concrete, real-world solutions over theoretical explorations.

\033[1m\033[4mKey Traits\033[0m
1. Action-oriented, energetic and spontaneous, pursuing immediate results.
2. Pragmatic, flexible and adaptable in problem-solving.
3. Direct, straightforward communicators, valuing honesty.
4. Excitement-seekers enjoy dynamic social interactions.

\033[1m\033[4mComprehensive Profile\033[0m
ESTPs are adventurous entrepreneurs, excelling in fast-paced environments. Strengths: adaptability, strategic thinking and practicality. They shine in business, sales, sports and emergency response. Growth areas: emotional intelligence, planning and reflection. ESTPs balance spontaneity with foresight, nurturing personal relationships.

\033[1m\033[4mMBTI Keywords\033[0m
1. Extraverted (E): Outgoing, assertive, social, energetic.
2. Sensing (S): Concrete, realistic, present-focused.
3. Thinking (T): Logical, analytical, objective.
4. Prospecting (P): Flexible, adaptable, spontaneous.
""","""
\033[1m\033[33mESFP (Explorers: Entertainer)
Extraverted (E), Sensing (S), Feeling (F), Prospecting (P)\033[0m

\033[1m\033[4mOverview\033[0m
ESFPs are vibrant entertainers, spreading energy, enthusiasm and spontaneity. They thrive on dynamic social interactions, seeking excitement and shared experiences. With an adaptable, practical nature, they effortlessly connect with diverse groups, fostering joy and collective engagement.

\033[1m\033[4mKey Traits\033[0m
1. Spontaneous, energetic and sociable, igniting excitement.
2. Practical, realistic and adaptable in daily life.
3. Empathetic, caring and generous, valuing connections.
4. Expressive, enthusiastic and fun-loving, embracing life's pleasures.

\033[1m\033[4mComprehensive Profile\033[0m
ESFPs are charismatic entertainers, shining in social, creative and fast-paced environments. Strengths: adaptability, emotional intelligence and generosity. They excel in arts, entertainment and hospitality. Growth areas: planning, reflection and emotional resilience. ESFPs balance spontaneity with responsibility, nurturing meaningful relationships.

\033[1m\033[4mMBTI Keywords\033[0m
1. Extraverted (E): Outgoing, assertive, social, energetic.
2. Sensing (S): Concrete, realistic, present-focused.
3. Feeling (F): Empathetic, compassionate, values-driven.
4. Prospecting (P): Flexible, adaptable, spontaneous.
""","""
\033[1m\033[32mENFP (Diplomats: Campaigner)
Extraverted (E), Intuitive (N), Feeling (F), Prospecting (P)\033[0m

\033[1m\033[4mOverview\033[0m
ENFPs are charismatic, creative free spirits, spreading enthusiasm and positivity. They thrive on meaningful connections, imaginative pursuits and spontaneous adventures, fueled by an intense desire for emotional connections and deeper life significance. Their vibrant energy flows in diverse directions.

\033[1m\033[4mKey Traits\033[0m
1. Enthusiastic, imaginative and energetic, inspiring others.
2. Creative, individualistic and insightful, seeking deeper meaning.
3. Warm, caring and optimistic, valuing emotional connections.
4. Spontaneous, flexible and playful, embracing life's possibilities.

\033[1m\033[4mComprehensive Profile\033[0m
ENFPs are vibrant campaigners, shining in social, creative and humanitarian realms. Strengths: creativity, emotional intelligence and adaptability. Growth areas: focus, emotional resilience and practicality. ENFPs balance spontaneity with empathy, nurturing profound relationships.

\033[1m\033[4mMBTI Keywords\033[0m
1. Extraverted: Outgoing, assertive, social, energetic.
2. Intuitive: Innovative, imaginative, strategic.
3. Feeling: Empathetic, compassionate, values-driven.
4. Prospecting: Flexible, adaptable, spontaneous.
""","""
\033[1m\033[34mENTP (Analysts: Debater)
Extraverted (E), Intuitive (N), Thinking (T), Prospecting(P)\033[0m

\033[1m\033[4mOverview\033[0m
ENTPs are innovative, audacious thinkers, who embrace intellectual challenges. They boldly deconstruct and rebuild ideas, vigorously pursuing goals despite resistance. With quick wit and playful humour, they spark lively debates, seeking knowledge and mental agility.

\033[1m\033[4mKey Traits\033[0m
1. Energetic, inventive and enthusiastic, fueling intellectual explorations.
2. Logical, theoretical and analytical, dissecting complex ideas.
3. Verbal, novelty-seeking and adaptable, thriving in dynamic discussions.
4. Independent, global and change-oriented, challenging conventions.

\033[1m\033[4mComprehensive Profile\033[0m
ENTPs are charismatic debaters, shining in intellectual, strategic and creative realms. Strengths: mental agility, resourcefulness and conceptual thinking. Growth areas: emotional intelligence, practicality and stability. ENTPs balance boldness with analytical depth.

\033[1m\033[4mMBTI Keywords\033[0m
1. Extraverted: Outgoing, assertive, social, energetic.
2. Intuitive: Innovative, imaginative, strategic.
3. Thinking: Logical, analytical, objective.
4. Prospecting: Flexible, adaptable, spontaneous.
""","""
\033[1m\033[31mESTJ (Sentinels: Executive)
Extraverted (E), Sensing (S), Thinking (T), Judging (J)\033[0m

\033[1m\033[4mOverview\033[0m
ESTJs are pragmatic organizers, excelling in management and leadership. They embody tradition, order and stability, guiding communities and families with sensible judgment and unwavering dedication.

\033[1m\033[4mKey Traits\033[0m
1. Practical, decisive and results-oriented, driving efficiency.
2. Logical, analytical and systematic, structuring plans.
3. Assertive, fact-minded and responsible, upholding standards.
4. Active, take-charge and common-sense, ensuring order.

\033[1m\033[4mComprehensive Profile\033[0m
ESTJs are steadfast executives, shining in organizational, leadership and community roles. Strengths: practicality, decisiveness and responsibility. Growth areas: flexibility, emotional intelligence and adaptability. ESTJs balance stability with strategic vision.

\033[1m\033[4mMBTI Keywords\033[0m
1. Extraverted: Outgoing, assertive, social, energetic.
2. Sensing: Practical, realistic, detail-focused.
3. Thinking: Logical, analytical, objective.
4. Judging: Structured, decisive, results-driven.
""","""
\033[1m\033[31mESFJ (Sentinels: Consul)
Extraverted (E), Sensing (S), Feeling (F), Judging (J)\033[0m

\033[1m\033[4mOverview\033[0m
ESFJs are compassionate, community-driven individuals fostering harmony and cooperation. They enrich lives through warmth, empathy and practical care, valuing interconnectedness and mutual support. Their decisive values guide actions, promoting stability.

\033[1m\033[4mKey Traits\033[0m
1. Warmhearted, caring and enthusiastic, nurturing meaningful relationships.
2. Practical, responsible and orderly, ensuring stability and efficiency.
3. Empathic, people-oriented and cooperative, resolving conflicts peacefully.
4. Loyal, conscientious and appreciative, cherishing personal connections.

\033[1m\033[4mComprehensive Profile\033[0m
ESFJs are dedicated consuls, excelling in interpersonal, community and supportive roles. Strengths: emotional intelligence, practicality and loyalty. Growth areas: adaptability, independence and assertiveness. ESFJs balance harmony with decisiveness, fostering cohesive environments.

\033[1m\033[4mMBTI Keywords\033[0m
1. Extraverted: Outgoing, assertive, social, energetic.
2. Sensing: Practical, realistic, detail-focused.
3. Feeling: Empathetic, compassionate, values-driven.
4. Judging: Structured, decisive, results-driven.
""","""
\033[1m\033[32mENFJ (Diplomats: Protagonist)
Extraverted (E), Intuitive (N), Feeling (F), Judging (J)\033[0m

\033[1m\033[4mOverview\033[0m
ENFJs are charismatic, idealistic leaders, driven to positively impact lives and communities. With empathy, enthusiasm and creative energy, they inspire growth, foster harmony and champion meaningful causes, embodying warmth and responsibility.

\033[1m\033[4mKey Traits\033[0m
1. Warm, empathetic and responsive, nurturing meaningful connections.
2. Idealistic, enthusiastic and imaginative, envisioning possibilities.
3. Cooperative, conscientious and appreciative, cultivating growth.
4. Sociable, tactful and expressive, facilitating harmonious interactions.

\033[1m\033[4mComprehensive Profile\033[0m
ENFJs are visionary protagonists, shining in leadership, coaching and mentoring roles. Strengths: emotional intelligence, charisma and idealism. Growth areas: flexibility, independence and self-care. ENFJs balance optimism with pragmatism, empowering others.

\033[1m\033[4mMBTI Keywords\033[0m
1. Extraverted: Outgoing, assertive, social, energetic.
2. Intuitive: Innovative, imaginative, strategic.
3. Feeling: Empathetic, compassionate, values-driven.
4. Judging: Structured, decisive, results-driven.
""","""
\033[1m\033[34mENTJ (Analysts: Commander)
Extraverted (E), Intuitive (N), Thinking (T), Judging (J)\033[0m

\033[1m\033[4mOverview\033[0m
ENTJs are visionary leaders, embodying charisma, confidence and strategic thinking. They boldly drive progress, innovate and achieve, fueled by creativity, rationality and unwavering determination.

\033[1m\033[4mKey Traits\033[0m
1. Decisive, driving and initiating, propelling change.
2. Vision-focused, conceptual and strategic, shaping futures.
3. Assertive, logical and systematic, streamlining processes.
4. Critical, organized and improvement-oriented, pursuing excellence.

\033[1m\033[4mComprehensive Profile\033[0m
ENTJs are commanding leaders, excelling in executive, entrepreneurial and innovative roles. Strengths: strategic thinking, charisma and resilience. Growth areas: emotional intelligence, flexibility and empathy. ENTJs balance confidence with a collaborative spirit.

\033[1m\033[4mMBTI Keywords\033[0m
1. Extraverted: Outgoing, assertive, social, energetic.
2. Intuitive: Innovative, imaginative, forward-thinking.
3. Thinking: Logical, analytical, objective.
4. Judging: Structured, decisive, results-driven.
"""};
  
  public String getSources(){
    return sources;
  }
  
  public String getPersonalityTypeSummary(String personalityType) {
    switch (personalityType){
      case "ISTJ": return personalityTypeSummary[0];
      case "ISFJ": return personalityTypeSummary[1];
      case "INFJ": return personalityTypeSummary[2];
      case "INTJ": return personalityTypeSummary[3];
      case "ISTP": return personalityTypeSummary[4];
      case "ISFP": return personalityTypeSummary[5];
      case "INFP": return personalityTypeSummary[6];
      case "INTP": return personalityTypeSummary[7];
      case "ESTP": return personalityTypeSummary[8];
      case "ESFP": return personalityTypeSummary[9];
      case "ENFP": return personalityTypeSummary[10];
      case "ENTP": return personalityTypeSummary[11];
      case "ESTJ": return personalityTypeSummary[12];
      case "ESFJ": return personalityTypeSummary[13];
      case "ENFJ": return personalityTypeSummary[14];
      case "ENTJ": return personalityTypeSummary[15];
	  }
	  return "";
	}

}


